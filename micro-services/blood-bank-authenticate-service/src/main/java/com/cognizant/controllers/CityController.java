package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.City;
import com.cognizant.service.CityService;

@RestController
public class CityController {
	@Autowired
	CityService cityService;

	@GetMapping("/cities/{stateId}")
	public List<City> getAllCitiesByStateId(@PathVariable int stateId) {
		return cityService.getAllCitiesByStateId(stateId);
	}
}
