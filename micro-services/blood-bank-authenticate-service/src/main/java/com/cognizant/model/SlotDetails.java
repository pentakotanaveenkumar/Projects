package com.cognizant.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="slot_details")
public class SlotDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="sd_donation_date")
	private Date donationDate;
	
	@Column(name="sd_donation_time")
	private String donationTime;
	
	@ManyToOne
	@JoinColumn(name = "sd_hs_id")
	private Hospital hospital;
	
	@Column(name="sd_units")
	private int units;
	
	@ManyToOne
	@JoinColumn(name="sd_us_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="sd_rp_id")
	private RequestPostingDetails requestPostingDetails;
	
	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public RequestPostingDetails getRequestPostingDetails() {
		return requestPostingDetails;
	}

	public void setRequestPostingDetails(RequestPostingDetails requestPostingDetails) {
		this.requestPostingDetails = requestPostingDetails;
	}
	
}
