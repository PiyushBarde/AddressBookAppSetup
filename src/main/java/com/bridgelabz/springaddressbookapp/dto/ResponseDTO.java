package com.bridgelabz.springaddressbookapp.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.springaddressbookapp.contactmodel.ContactDetails;

public class ResponseDTO {
	@Autowired
	ContactDetails contact;
	
	private String message;
	private ContactDetails content;
}
