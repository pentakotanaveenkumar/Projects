package com.cognizant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "area")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ar_id")
	private int id;
	@Column(name = "ar_name")
	private String name;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ar_ct_id")
	private City city;
	@OneToMany(mappedBy = "area")
	private List<Hospital> hospitalList;
	@OneToMany(mappedBy = "area")
	private List<DonationDetails> donationDetails;
	@OneToMany(mappedBy = "area")
	private List<RequestPostingDetails> requestPostingDetails;
	@OneToOne(mappedBy = "area")
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Hospital> getHospital() {
		return hospitalList;
	}

	public void setHospital(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}

	/*
	 * public DonationDetails getDonationDetails() { return donationDetails; }
	 * public void setDonationDetails(DonationDetails donationDetails) {
	 * this.donationDetails = donationDetails; }
	 */
	public Area() {
		super();
	}

	public Area(String name, City city, List<Hospital> hospitalList, List<DonationDetails> donationDetails) {
		super();
		this.name = name;
		this.city = city;
		this.hospitalList = hospitalList;
		this.donationDetails = donationDetails;
	}

	public Area(int id, String name, City city, List<Hospital> hospitalList, List<DonationDetails> donationDetails) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.hospitalList = hospitalList;
		this.donationDetails = donationDetails;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", city=" + city + ", hospital=" + hospitalList
				+ ", donationDetails=" + donationDetails + "]";
	}
}
