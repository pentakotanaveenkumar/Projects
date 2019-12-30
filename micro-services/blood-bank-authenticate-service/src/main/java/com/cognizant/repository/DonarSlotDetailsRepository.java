package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.model.DonarSlotBookingDetails;

@Repository
public interface DonarSlotDetailsRepository extends JpaRepository<DonarSlotBookingDetails, Integer>{
	@Query(value="select ds_dd_id from donor_slot_details  where ds_donation_date<=DATE_ADD(CURRENT_DATE(), INTERVAL 1 DAY) and ds_donation_date>=DATE_SUB(CURRENT_DATE(),INTERVAL 41 DAY)",nativeQuery=true) 
	List<Integer> getAllIds();
	
	@Query(value="select ds_dd_id from donor_slot_details where ds_donation_date<=DATE_SUB(CURRENT_DATE(),INTERVAL 89 DAY)",nativeQuery=true)
	List<Integer> getActiveDonarIds();
	
}
