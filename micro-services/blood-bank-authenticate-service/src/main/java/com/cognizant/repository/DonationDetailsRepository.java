package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.DonationDetails;

@Repository
public interface DonationDetailsRepository extends JpaRepository<DonationDetails, Integer> {
	@Query("select d from DonationDetails d where dd_st_id=:stateId and dd_ct_id=:cityId and dd_ar_id=:areaId and dd_bg_id=:bloodGroupId")
	List<DonationDetails> getAllDonationDetails(@Param("stateId") int stateId, @Param("cityId") int cityId,
			@Param("areaId") int areaId, @Param("bloodGroupId") int bloodGroupId);
	
	@Query("select d from DonationDetails d where dd_id=:id and dd_st_id=:stateId and dd_ct_id=:cityId and dd_ar_id=:areaId and dd_bg_id=:bloodGroupId")
	DonationDetails getAllDonationDetailsById(@Param("id") int id,@Param("stateId") int stateId, @Param("cityId") int cityId,
			@Param("areaId") int areaId, @Param("bloodGroupId") int bloodGroupId);
	
	@Query("select d from DonationDetails d where dd_us_id=:userId and dd_id=:id")
	DonationDetails getAllDonationDetailsByUserId(@Param("userId") int userId,@Param("id") int id);
	
	@Query("select d from DonationDetails d where dd_us_id=:userId")
	DonationDetails getDonorDetailsByUserId(@Param("userId") int userId);
}
