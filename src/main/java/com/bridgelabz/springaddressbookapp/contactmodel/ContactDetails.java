package com.bridgelabz.springaddressbookapp.contactmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.springaddressbookapp.dto.RequestDTO;

@Entity
public class ContactDetails {
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private String city;
	private String state;
	private Integer zip;
	
	public ContactDetails(ContactDetails contact) {
		super();
		this.id = contact.getId();
		this.firstName = contact.getFirstName();
		this.lastName = contact.getLastName();
		this.email = contact.getEmail();
		this.phoneNumber = contact.getPhoneNumber();
		this.city = contact.getCity();
		this.state = contact.getCity();
		this.zip = contact.getZip();
	}
	
	public ContactDetails(RequestDTO dto) {
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.email = dto.getEmail();
		this.phoneNumber = dto.getPhoneNumber();
		this.city = dto.getCity();
		this.state = dto.getCity();
		this.zip = dto.getZip();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}


	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	public ContactDetails(Integer id, RequestDTO dto) {
		super();
	}
	public ContactDetails(Integer id, ContactDetails contact) {
		this.id = id;
		this.firstName = contact.getFirstName();
		this.lastName = contact.getLastName();
		this.email = contact.getEmail();
		this.phoneNumber = contact.getPhoneNumber();
		this.city = contact.getCity();
		this.state = contact.getCity();
		this.zip = contact.getZip();
	}
}
