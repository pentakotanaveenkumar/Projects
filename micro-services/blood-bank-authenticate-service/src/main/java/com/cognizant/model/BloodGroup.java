package com.cognizant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blood_group")
public class BloodGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bg_id")
	private int id;
	@Column(name = "bg_name")
	private String name;

	@OneToMany(mappedBy = "bloodGroup")
	private List<BloodBank> bloodBankList;

	@OneToMany(mappedBy = "bloodGroup")
	private List<DonationDetails> donationDetails;
	
	@OneToMany(mappedBy = "bloodGroup")
	private List<RequestPostingDetails> requestPostingDetails;

	@OneToOne(mappedBy = "bloodGroup")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BloodGroup() {
		super();
	}

	public BloodGroup(String name, List<BloodBank> bloodBankList, List<DonationDetails> donationDetails) {
		super();
		this.name = name;
		this.bloodBankList = bloodBankList;
		this.donationDetails = donationDetails;
	}

	public BloodGroup(int id, String name, List<BloodBank> bloodBankList, List<DonationDetails> donationDetails) {
		super();
		this.id = id;
		this.name = name;
		this.bloodBankList = bloodBankList;
		this.donationDetails = donationDetails;
	}

	@Override
	public String toString() {
		return "BloodGroup [id=" + id + ", name=" + name + ", bloodBank=" + bloodBankList + ", donationDetails="
				+ donationDetails + "]";
	}

	public BloodGroup(String name) {
		super();
		this.name = name;
	}

}
