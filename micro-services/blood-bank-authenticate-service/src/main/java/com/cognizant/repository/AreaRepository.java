package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
	@Query("select a from Area a where ar_ct_id=:ct_id")
	List<Area> getAllAreasByCityId(@Param("ct_id") int cityId);
}
