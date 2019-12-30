package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.State;
import com.cognizant.repository.StateRepository;

@Service
public class StateService {
	@Autowired
	StateRepository stateRepository;
	
	@Transactional
	public List<State> getAllStates(){
		return stateRepository.findAll();
	}
}
