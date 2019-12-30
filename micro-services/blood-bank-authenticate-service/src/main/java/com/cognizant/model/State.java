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
@Table(name = "state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "st_id")
	private int id;
	@Column(name = "st_name")
	private String name;
	@OneToMany(mappedBy = "state")
	private List<City> cityList;
	@OneToMany(mappedBy = "state")
	private List<DonationDetails> donationDetails;
	@OneToMany(mappedBy = "state")
	private List<RequestPostingDetails> requestPostingDetails;
	@OneToOne(mappedBy = "state")
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

	public List<City> getCity() {
		return cityList;
	}

	public void setCity(List<City> cityList) {
		this.cityList = cityList;
	}

	/*
	 * public DonationDetails getDonationDetails() { return donationDetails; }
	 * public void setDonationDetails(DonationDetails donationDetails) {
	 * this.donationDetails = donationDetails; }
	 */
	public State() {
		super();
	}

	public State(String name, List<City> cityList, List<DonationDetails> donationDetails) {
		super();
		this.name = name;
		this.cityList = cityList;
		this.donationDetails = donationDetails;
	}

	public State(int id, String name, List<City> cityList) {
		super();
		this.id = id;
		this.name = name;
		this.cityList = cityList;
	}

	public State(int id, String name, List<City> cityList, List<DonationDetails> donationDetails) {
		super();
		this.id = id;
		this.name = name;
		this.cityList = cityList;
		this.donationDetails = donationDetails;
	}
}
