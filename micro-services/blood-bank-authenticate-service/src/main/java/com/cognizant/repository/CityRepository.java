package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	@Query("select c from City c where ct_st_id=:st_id")
	List<City> getAllCitiesByStateId(@Param("st_id") int stateId);
}
