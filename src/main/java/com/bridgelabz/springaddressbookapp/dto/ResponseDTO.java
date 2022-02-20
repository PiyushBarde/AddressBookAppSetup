package com.bridgelabz.springaddressbookapp.dto;


import com.bridgelabz.springaddressbookapp.contactmodel.ContactDetails;

/**
 * @author Piyush
 *
 */
public class ResponseDTO {
	
	private String message;
	private ContactDetails contact;
	public ResponseDTO(String message,ContactDetails contact) {
		super();
		this.contact = contact;
		this.message = message;
	}
	
	public ContactDetails getContact() {
		return contact;
	}
	public void setContact(ContactDetails contact) {
		this.contact = contact;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
