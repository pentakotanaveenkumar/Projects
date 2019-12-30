package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Feedback;
import com.cognizant.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping()
	public List<Feedback> getAllFeedbacks(){
		return feedbackService.getAllFeedbacks();
	}
	
	@PostMapping
	public void addFeedback(@RequestBody Feedback feedback){
		 feedbackService.addFeedback(feedback);
	}
}
