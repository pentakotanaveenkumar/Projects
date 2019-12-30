package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	@Query("select h from Hospital h where hs_ar_id=:ar_id")
	List<Hospital> getAllHospitalsByAreaId(@Param("ar_id") int areaId);
}
