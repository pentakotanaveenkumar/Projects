package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Faqs;
import com.cognizant.service.FaqsService;

@RestController
@RequestMapping("/faqs")
public class FaqsController {
	@Autowired
	FaqsService faqsService;
	
	@GetMapping("/answered")
	public List<Faqs> getAllAnsweredFaqs(){
		return faqsService.getAllAnsweredFaqs();
	}
	
	@GetMapping("/unanswered")
	public List<Faqs> getAllUnAnsweredFaqs(){
		return faqsService.getAllUnAnsweredFaqs();
	}
	
	@PostMapping()
	public void addQuestioninFaqs(@RequestBody Faqs faqs) {
		faqsService.addQuestioninFaqs(faqs);
	}
	@PutMapping("/{id}")
	public void addAnswerInFaqs(@RequestBody String answer,@PathVariable int id) {
		faqsService.addAnswerInFaqs(answer, id);
	}
	
	@GetMapping("/{username}")
	public List<Faqs> getAllAnsweredFaqsOfSingleUser(@PathVariable String username){
		return	faqsService.getAllAnsweredFaqsOfSingleUser(username);
	}
}
