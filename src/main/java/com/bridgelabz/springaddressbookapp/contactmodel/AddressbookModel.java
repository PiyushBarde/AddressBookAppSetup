package com.bridgelabz.springaddressbookapp.contactmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.springaddressbookapp.dto.AddressbookDTO;

import lombok.Data;

@Entity
@Data
public class AddressbookModel {
	
	public AddressbookModel() {
		super();
	}

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

	public AddressbookModel(AddressbookModel contact) {
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
	
	
	public AddressbookModel(AddressbookDTO dto) {
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.email = dto.getEmail();
		this.phoneNumber = dto.getPhoneNumber();
		this.city = dto.getCity();
		this.state = dto.getCity();
		this.zip = dto.getZip();
	}
	
	//used to update the data
	public AddressbookModel(Integer id, AddressbookDTO dto) {
		this.id = id;
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.email = dto.getEmail();
		this.phoneNumber = dto.getPhoneNumber();
		this.city = dto.getCity();
		this.state = dto.getCity();
		this.zip = dto.getZip();
	}	
}
