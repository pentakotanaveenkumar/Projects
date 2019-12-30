package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.DonationDetails;
import com.cognizant.model.User;
import com.cognizant.repository.DonarSlotDetailsRepository;
import com.cognizant.repository.DonationDetailsRepository;
import com.cognizant.repository.UserRepository;

@Service
public class DonationDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DonationDetailsService.class);
	@Autowired
	DonationDetailsRepository donationDetailsRepository;
	@Autowired
	DonarSlotDetailsRepository donarSlotDetailsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	DonationDetails donationDetails;
	
	@Transactional
	public List<DonationDetails> getAllDonationDetailsById(int stateId,int cityId,int areaId,int bloodGroupId){
		List<DonationDetails> donationDetailsList=new ArrayList<DonationDetails>();
		List<Integer> idList=new ArrayList<Integer>();
		idList=donarSlotDetailsRepository.getAllIds();
		for(int id:idList) {
			System.out.println(id);
			donationDetails=donationDetailsRepository.getAllDonationDetailsById(id, stateId, cityId, areaId, bloodGroupId);
			if(donationDetails!=null)
				donationDetailsList.add(donationDetails);
		}
		return donationDetailsList;
	}
	@Transactional
	public List<DonationDetails> getAllDonationDetails(int stateId,int cityId,int areaId,int bloodGroupId) {
		LOGGER.debug("Inside getAllDonationDetails Service");
		return donationDetailsRepository.getAllDonationDetails(stateId,cityId,areaId,bloodGroupId);
	}
	
	@Transactional
	public void addDonationDetails(DonationDetails donationDetails) {
		LOGGER.debug("Inside addDonationDetails Service");
		donationDetailsRepository.save(donationDetails);
	}

	@Transactional
	public boolean isDonarActiveToDonate(String username) {
		boolean active = false;
		User user=userRepository.findbyUsername(username);
		List<Integer> ids=new ArrayList<Integer>();
		ids=donarSlotDetailsRepository.getActiveDonarIds();
		DonationDetails donarDeatils=donationDetailsRepository.getDonorDetailsByUserId(user.getId());
		if(!ids.isEmpty()) {
			for(int id:ids) {
				System.out.println(id);
				donationDetails=donationDetailsRepository.getAllDonationDetailsByUserId(user.getId(),id);
				if(donationDetails==null) {
				active=true;
				}		
			}
		}else if(donarDeatils==null){
			active=true;
		}
		return active;
	}
	
	@Transactional
	public boolean isActiveDonarToDonate(String username) {
		boolean active = false;
		User user=userRepository.findbyUsername(username);
		List<Integer> ids=new ArrayList<Integer>();
		ids=donarSlotDetailsRepository.getActiveDonarIds();
		DonationDetails donarDeatils=donationDetailsRepository.getDonorDetailsByUserId(user.getId());
		if(ids.isEmpty()) {
			active=true;
		}
		else if(!ids.isEmpty()) {
			for(int id:ids) {
				System.out.println(id);
				donationDetails=donationDetailsRepository.getAllDonationDetailsByUserId(user.getId(),id);
				if(donationDetails==null) {
					active=true;
				}else
					active=false;
			}
		}else if(donarDeatils==null){
			active=true;
		}
		return active;
	}
}
