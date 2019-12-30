package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * from user where us_username=?1", nativeQuery = true)
	User findbyUsername(String username);

}
