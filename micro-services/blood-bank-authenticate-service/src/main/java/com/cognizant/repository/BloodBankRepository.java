package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.BloodBank;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank, Integer> {

}
