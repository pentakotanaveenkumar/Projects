package com.cognizant.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="donor_slot_details")
public class DonarSlotBookingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ds_donation_date")
	private Date donationDate;
	
	@Column(name="ds_donation_time")
	private String donationTime;
	
	@ManyToOne
	@JoinColumn(name = "ds_hs_id")
	private Hospital hospital;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ds_dd_id")
	private DonationDetails donationDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public String getDonationTime() {
		return donationTime;
	}

	public void setDonationTime(String donationTime) {
		this.donationTime = donationTime;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public DonationDetails getDonationDetails() {
		return donationDetails;
	}

	public void setDonationDetails(DonationDetails donationDetails) {
		this.donationDetails = donationDetails;
	}
	
}
