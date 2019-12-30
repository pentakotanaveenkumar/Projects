package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.BloodGroup;
import com.cognizant.repository.BloodGroupRepository;

@Service
public class BloodGroupService {
	@Autowired
	BloodGroupRepository bloodGroupRepository;
	
	@Transactional
	public List<BloodGroup> getAllBloodgroups(){
		return bloodGroupRepository.findAll();
	}
}
