package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="blood_bank")
public class BloodBank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bb_id")
	private int id;
	@Column(name="bb_units")
	private int units;
	@OneToOne
	@JoinColumn(name="bb_hs_id")
	private SlotDetails slotDetails;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="bb_bg_id")
	private BloodGroup bloodGroup;
	
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
	
	public SlotDetails getSlotDetails() {
		return slotDetails;
	}
	public void setSlotDetails(SlotDetails slotDetails) {
		this.slotDetails = slotDetails;
	}
	public BloodBank() {
		super();
	}
	public BloodBank(int units, BloodGroup bloodGroup) {
		super();
		this.units = units;
		this.bloodGroup = bloodGroup;
	}
	public BloodBank(int id, int units, BloodGroup bloodGroup) {
		super();
		this.id = id;
		this.units = units;
		this.bloodGroup = bloodGroup;
	}
	@Override
	public String toString() {
		return "BloodBank [id=" + id + ", units=" + units +  ", bloodGroup=" + bloodGroup
				+ "]";
	}
	
}
