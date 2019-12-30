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
import javax.persistence.Table;

@Entity
@Table(name="request_posting_details")
public class RequestPostingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rp_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="rp_st_id")
	private State state;
	
	@ManyToOne
	@JoinColumn(name="rp_ct_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="rp_ar_id")
	private Area area;
	
	@Column(name="rp_contact_number")
	private long contactNumber;
	
	@ManyToOne
	@JoinColumn(name="rp_bg_id")
	private BloodGroup bloodGroup;
	
	@ManyToOne
	@JoinColumn(name="rp_us_id")
	private User user;
	
	@Column(name="rp_units")
	private int units;
	
	@OneToMany(mappedBy="requestPostingDetails")
	private List<SlotDetails> slotDetails;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RequestPostingDetails() {
		super();
	}
	public RequestPostingDetails(State state, City city, Area area, long contactNumber, BloodGroup bloodGroup) {
		super();
		this.state = state;
		this.city = city;
		this.area = area;
		this.contactNumber = contactNumber;
		this.bloodGroup = bloodGroup;
	}

	public RequestPostingDetails(int id, State state, City city, Area area, long contactNumber, BloodGroup bloodGroup) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
		this.area = area;
		this.contactNumber = contactNumber;
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "DonationDetails [id=" + id + ", state=" + state + ", city=" + city + ", area=" + area
				+ ", contactNumber=" + contactNumber + ", bloodGroup=" + bloodGroup + "]";
	}
	
}
