package com.cognizant.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="us_id")
	private int id;
	
	@NotNull(message="User name is required")
	@Column(name = "us_username")
	private String username;

	@Column(name = "us_password")
	private String password;

	@Column(name = "us_firstname")
	private String firstName;

	@Column(name = "us_lastname")
	private String lastName;

	@Column(name = "us_age")
	private int age;

	@Column(name = "us_gender")
	private String gender;

	@Column(name = "us_contact_number")
	private long contactNumber;

	@Column(name = "us_email")
	private String email;

	@Column(name = "us_weight")
	private int weight;

	@Column(name = "us_pincode")
	private long pincode;

	@OneToOne
	@JoinColumn(name="us_st_id")
	private State state;
	
	@OneToOne
	@JoinColumn(name="us_ct_id")
	private City city;
	
	@OneToOne
	@JoinColumn(name="us_ar_id")
	private Area area;
	
	@OneToOne
	@JoinColumn(name="us_bg_id")
	private BloodGroup bloodGroup;
	
	@OneToMany(mappedBy="user")
	private List<DonationDetails> donationDetails;
	
	@OneToMany(mappedBy="user")
	private List<SlotDetails> slotDetails;
	
	@OneToMany(mappedBy = "user")
	private List<RequestPostingDetails> requestPostingDetails;
	
	@OneToMany(mappedBy = "user")
	private List<Feedback> feedback;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id"), inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> rolesList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(String username, String password, String firstName, String lastName, int age, String gender,
			long contactNumber, String email, int weight, String state, String area, long pincode, String bloodGroup,
			Set<Role> rolesList) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.weight = weight;
		this.pincode = pincode;
		this.rolesList = rolesList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Set<Role> getRolesList() {
		return rolesList;
	}

	public void setRolesList(Set<Role> rolesList) {
		this.rolesList = rolesList;
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

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public User() {
		super();
		LOGGER.debug("User Default Constructor");
	}
}
