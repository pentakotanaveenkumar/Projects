package com.cognizant.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.DonationDetails;
import com.cognizant.service.DonationDetailsService;


@RestController
@RequestMapping("/donationDetails")
public class DonationDetailsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DonationDetailsController.class);
	@Autowired
	DonationDetailsService donationDetailsService;
	
	@GetMapping("/d/{stateId}/{cityId}/{areaId}/{bloodGroupId}")
	public List<DonationDetails> getAllDonationDetails(@PathVariable("stateId") int stateId,@PathVariable("cityId") int cityId,@PathVariable("areaId") int areaId,@PathVariable("bloodGroupId") int bloodGroupId) {
		LOGGER.debug("Inside getAllDonationDetails Controller");
		return donationDetailsService.getAllDonationDetails(stateId,cityId,areaId,bloodGroupId);
	}
	@GetMapping("/{stateId}/{cityId}/{areaId}/{bloodGroupId}")
	public List<DonationDetails> getAllDonationDetailsById(@PathVariable("stateId") int stateId,@PathVariable("cityId") int cityId,@PathVariable("areaId") int areaId,@PathVariable("bloodGroupId") int bloodGroupId) {
		LOGGER.debug("Inside getAllDonationDetailsById Controller");
		return donationDetailsService.getAllDonationDetailsById(stateId,cityId,areaId,bloodGroupId);
	}
	@PostMapping()
	public void addToDonationDetails(@RequestBody DonationDetails donationDetails) {
		LOGGER.debug("Inside addDonationDetails Controller");
		donationDetailsService.addDonationDetails(donationDetails);
	}
	@GetMapping("/{username}")
	public boolean isDonarActiveToDonate(@PathVariable String username) {
		return donationDetailsService.isDonarActiveToDonate(username);
	}
}
