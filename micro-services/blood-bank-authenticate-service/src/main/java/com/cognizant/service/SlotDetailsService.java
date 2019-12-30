package com.cognizant.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.SlotDetails;
import com.cognizant.model.User;
import com.cognizant.repository.SlotDetailsRepository;
import com.cognizant.repository.UserRepository;

@Service	
public class SlotDetailsService {
	@Autowired
	SlotDetailsRepository slotDetailsRepository;
	@Autowired
	UserRepository userRepository;
	
	SlotDetails slotDetails;
	
	@Transactional
	public void addSlotDetails(SlotDetails slotDetails) {
		slotDetailsRepository.save(slotDetails);
	}
	@Transactional
	public boolean isActiveDonor(String username) {
		boolean active=false;
		User user=userRepository.findbyUsername(username);
		slotDetails=slotDetailsRepository.getActiveDonar(user.getId());
		System.out.println(user.getId());
		if(slotDetails==null) {
			active=true;
		}
		return active;
	}
	
}
