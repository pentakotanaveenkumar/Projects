package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
