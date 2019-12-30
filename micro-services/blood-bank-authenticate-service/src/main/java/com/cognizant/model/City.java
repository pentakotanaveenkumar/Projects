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
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ct_id")
	private int id;
	@Column(name = "ct_name")
	private String name;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ct_st_id")
	private State state;
	@OneToMany(mappedBy = "city")
	private List<Area> areaList;
	@OneToMany(mappedBy = "city")
	private List<DonationDetails> donationDetails;
	@OneToMany(mappedBy = "city")
	private List<RequestPostingDetails> requestPostingDetails;
	@OneToOne(mappedBy = "city")
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Area> getArea() {
		return areaList;
	}

	public void setArea(List<Area> areaList) {
		this.areaList = areaList;
	}

	/*
	 * public DonationDetails getDonationDetails() { return donationDetails; }
	 * public void setDonationDetails(DonationDetails donationDetails) {
	 * this.donationDetails = donationDetails; }
	 */
	public City() {
		super();
	}

	public City(String name, State state, List<Area> areaList, List<DonationDetails> donationDetails) {
		super();
		this.name = name;
		this.state = state;
		this.areaList = areaList;
		this.donationDetails = donationDetails;
	}

	public City(int id, String name, State state, List<Area> areaList, List<DonationDetails> donationDetails) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.areaList = areaList;
		this.donationDetails = donationDetails;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", state=" + state + ", area=" + areaList + ", donationDetails="
				+ donationDetails + "]";
	}

}
