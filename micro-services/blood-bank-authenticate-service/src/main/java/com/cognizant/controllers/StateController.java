package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.State;
import com.cognizant.service.StateService;

@RestController
public class StateController {
	@Autowired
	StateService stateService;
	
	@GetMapping("/states")
	public List<State> getAllStates(){
		return stateService.getAllStates();
	}
}
