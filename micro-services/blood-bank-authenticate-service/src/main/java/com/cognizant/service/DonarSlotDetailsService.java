package com.cognizant.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.DonarSlotBookingDetails;
import com.cognizant.repository.DonarSlotDetailsRepository;
@Service
public class DonarSlotDetailsService {
	@Autowired
	DonarSlotDetailsRepository donationDetailsRepository;
	
	@Transactional
	public void addSlotDetails(DonarSlotBookingDetails donorSlotDetails) {
		donationDetailsRepository.save(donorSlotDetails);
	}
}
