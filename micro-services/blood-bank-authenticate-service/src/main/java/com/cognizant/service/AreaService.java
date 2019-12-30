package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Area;
import com.cognizant.repository.AreaRepository;

@Service
public class AreaService {
	@Autowired
	AreaRepository areaRepository;

	public List<Area> getAllAreasByStateId(int cityId) {
		return areaRepository.getAllAreasByCityId(cityId);
	}
}
