package com.cognizant.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.RequestPostingDetails;
import com.cognizant.service.RequestPostingDetailsService;

@RestController
@RequestMapping("/requestPostingDetails")
public class RequestPostingDetailsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestPostingDetailsController.class);
	@Autowired
	RequestPostingDetailsService requestPostingDetailsService;
	
	@GetMapping()
	public List<RequestPostingDetails> getAllRequestPostingDetails() {
		LOGGER.debug("Inside getAllRequestPostingDetails Controller");
		return requestPostingDetailsService.getAllRequestPostingDetails();
	}
	@PostMapping()
	public void addToRequestPostingDetails(@RequestBody RequestPostingDetails requestPostingDetails) {
		LOGGER.debug("Inside addRequestPosting Controller");
		requestPostingDetailsService.addRequestPostingDetails(requestPostingDetails);
	}
	
	@GetMapping("/{id}")
	public RequestPostingDetails getRequestPostingDetailsById(@PathVariable("id") int id) {
		return requestPostingDetailsService.getRequestPostingDetailsById(id);
	}
	
	@PutMapping("/{units}")
	public void putPostingDetails(@RequestBody RequestPostingDetails requestPostingDetails,@PathVariable int units) {
		requestPostingDetailsService.putPostingDetails(requestPostingDetails,units);
	}
}
