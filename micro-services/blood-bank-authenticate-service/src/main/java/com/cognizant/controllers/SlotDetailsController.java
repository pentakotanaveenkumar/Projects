package com.cognizant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.SlotDetails;
import com.cognizant.service.SlotDetailsService;

@RestController
@RequestMapping("/slotDetails")
public class SlotDetailsController {
	@Autowired
	SlotDetailsService slotDetailsService;
	
	@PostMapping
	public void addSlotDetails(@RequestBody SlotDetails slotDetails) {
		slotDetailsService.addSlotDetails(slotDetails);
	}
	
	@GetMapping("/{username}")
	public boolean isActiveDonar(@PathVariable String username) {
		return slotDetailsService.isActiveDonor(username);
	}
}
