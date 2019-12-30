package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.RequestPostingDetails;
import com.cognizant.repository.RequestPostingDetailsRepository;

@Service
public class RequestPostingDetailsService {
	@Autowired
	RequestPostingDetailsRepository requestPostingDetailsRepository;
	
	@Transactional
	public List<RequestPostingDetails> getAllRequestPostingDetails(){
		return requestPostingDetailsRepository.getAllRequestPostingDetails();
	}
	
	@Transactional
	public void addRequestPostingDetails(RequestPostingDetails requestPostingDetails) {
		requestPostingDetailsRepository.save(requestPostingDetails);
	}
	
	@Transactional
	public RequestPostingDetails getRequestPostingDetailsById(int id) {
		return requestPostingDetailsRepository.getRequestPostingDetailsById(id);
	}
	
	@Transactional
	public void putPostingDetails( RequestPostingDetails requestPostingDetails, int units) {
		if(requestPostingDetails.getUnits()>=units) {
			requestPostingDetails.setUnits(requestPostingDetails.getUnits()-units);
			requestPostingDetailsRepository.save(requestPostingDetails);
		}
	}
	
}
