package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.RequestPostingDetails;

@Repository
public interface RequestPostingDetailsRepository extends JpaRepository<RequestPostingDetails, Integer> {
	@Query(value="select r from RequestPostingDetails r where r.id=:id")
	RequestPostingDetails getRequestPostingDetailsById(@Param("id") int id);
	
	@Query(value="select r from RequestPostingDetails r where rp_units>0")
	List<RequestPostingDetails> getAllRequestPostingDetails();
}
