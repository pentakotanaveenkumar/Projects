package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.City;
import com.cognizant.repository.CityRepository;

@Service
public class CityService {
	@Autowired
	CityRepository cityRepository;
	
	@Transactional
	 public List<City> getAllCitiesByStateId(int stateId){
		 return cityRepository.getAllCitiesByStateId(stateId);
	 }
}
