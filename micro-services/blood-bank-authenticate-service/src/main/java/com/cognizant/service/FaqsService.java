package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Faqs;
import com.cognizant.model.User;
import com.cognizant.repository.FaqsRepository;
import com.cognizant.repository.UserRepository;

@Service
public class FaqsService {
	@Autowired
	FaqsRepository faqsRepository;
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public List<Faqs> getAllAnsweredFaqs(){
		return faqsRepository.getAllAnsweredQueries();
	}
	@Transactional
	public List<Faqs> getAllUnAnsweredFaqs(){
		return faqsRepository.getAllUnAnsweredQueries();
	}
	@Transactional
	public void addQuestioninFaqs(Faqs faqs) {
		faqs.setStatus(0);
		faqsRepository.save(faqs);
	}
	@Transactional
	public void addAnswerInFaqs(String answer,int id) {
		Faqs faq=new Faqs();
		faq=faqsRepository.getFaqById(id);
		faq.setId(id);
		faq.setAnswer(answer);
		faq.setStatus(2);
		faqsRepository.save(faq);
	}
	@Transactional
	public List<Faqs> getAllAnsweredFaqsOfSingleUser(String username){
		List<Faqs> faqsList=new ArrayList<Faqs>();
		User user=userRepository.findbyUsername(username);
		List<Faqs> faqs=faqsRepository.findByUserAndStatus(user, 2);
		for(Faqs f:faqs) {
			f.setStatus(1);
			faqsList.add(f);
		}
		return faqsList;
	}
}
