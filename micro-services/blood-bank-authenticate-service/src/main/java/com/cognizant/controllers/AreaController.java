package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Area;
import com.cognizant.service.AreaService;

@RestController
public class AreaController {
	@Autowired
	AreaService areaService;
	
	@GetMapping("/areas/{cityId}")
	public List<Area> getAllAreasByCityId(@PathVariable int cityId){
		return areaService.getAllAreasByStateId(cityId);
	}
}
