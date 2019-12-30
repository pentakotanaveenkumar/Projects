package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Faqs;
import com.cognizant.model.User;

@Repository
public interface FaqsRepository extends JpaRepository<Faqs, Integer> {
	@Query(value="select f from Faqs f where fq_answer!=null")
	List<Faqs> getAllAnsweredQueries();
	
	@Query(value="select f from Faqs f where fq_answer is null")
	List<Faqs> getAllUnAnsweredQueries();
	
	@Query(value="select f from Faqs f where id=:id")
	Faqs getFaqById(@Param("id")int id);
	
	List<Faqs> findByUserAndStatus(User user,int status);

}
