package com.cognizant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.DonarSlotBookingDetails;
import com.cognizant.service.DonarSlotDetailsService;

@RestController
@RequestMapping("/donorSlotDeatils")
public class DonarSlotDetailsController {
	@Autowired
	DonarSlotDetailsService donorSlotDetailsService;
	
	@PostMapping
	public void addSlotDetails(@RequestBody DonarSlotBookingDetails slotDetails) {
		donorSlotDetailsService.addSlotDetails(slotDetails);
	}
}
