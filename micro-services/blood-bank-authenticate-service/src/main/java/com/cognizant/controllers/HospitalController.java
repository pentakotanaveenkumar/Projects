package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Hospital;
import com.cognizant.service.HospitalService;

@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	@GetMapping("/hospitals/{areaId}")
	public List<Hospital> getAllHospitalsByAreaId(@PathVariable int areaId){
		return hospitalService.getAllHospitalsByAreaId(areaId);
	}
}
