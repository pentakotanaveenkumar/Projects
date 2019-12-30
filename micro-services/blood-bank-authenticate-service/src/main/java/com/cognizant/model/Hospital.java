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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hospital")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hs_id")
	private int id;
	@Column(name = "hs_name")
	private String name;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "hs_ar_id")
	private Area area;
	
	@OneToMany(mappedBy="hospital")
	private List<SlotDetails> slotDetails; 
	
	@OneToMany(mappedBy="hospital")
	private List<DonarSlotBookingDetails> donationDetails; 

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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Hospital() {
		super();
	}

	public Hospital(String name, Area area) {
		super();
		this.name = name;
		this.area = area;
	}

	public Hospital(int id, String name, Area area) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", area=" + area + "]";
	}

}
