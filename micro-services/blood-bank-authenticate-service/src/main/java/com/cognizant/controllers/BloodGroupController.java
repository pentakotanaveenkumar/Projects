package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.BloodGroup;
import com.cognizant.service.BloodGroupService;

@RestController
public class BloodGroupController {
	@Autowired
	BloodGroupService bloodGroupService;
	
	@GetMapping("/bloodGroups")
	public List<BloodGroup> getAllBloodGroup(){
		return bloodGroupService.getAllBloodgroups();
	}
}
