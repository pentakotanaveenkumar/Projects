package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Hospital;
import com.cognizant.repository.HospitalRepository;

@Service
public class HospitalService {
	@Autowired
	HospitalRepository hospitalRepository;
	
	@Transactional
	public List<Hospital> getAllHospitalsByAreaId(int areaId){
		return hospitalRepository.getAllHospitalsByAreaId(areaId);
	}
}
