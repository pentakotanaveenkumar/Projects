package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.SlotDetails;

@Repository
public interface SlotDetailsRepository extends JpaRepository<SlotDetails, Integer>{
	
	@Query(value="select * from slot_details where sd_us_id=?1 and sd_donation_date>=DATE_SUB(CURRENT_DATE(),INTERVAL 89 DAY) ",nativeQuery=true)
	SlotDetails getActiveDonar(@Param("userId") int userId);
	
	//SlotDetails findByUserAndDonationDateBetween(User user,Date startDate,Date endDate);
	
}
