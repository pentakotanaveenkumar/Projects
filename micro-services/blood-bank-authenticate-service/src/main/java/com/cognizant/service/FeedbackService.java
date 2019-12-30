package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Feedback;
import com.cognizant.repository.FeedbackRepository;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Transactional
	public List<Feedback> getAllFeedbacks(){
		return feedbackRepository.findAll();
	}
	
	@Transactional
	public void addFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
}
