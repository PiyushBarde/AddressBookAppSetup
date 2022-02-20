package com.bridgelabz.springaddressbookapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.springaddressbookapp.contactmodel.ContactDetails;
import com.bridgelabz.springaddressbookapp.dto.RequestDTO;
import com.bridgelabz.springaddressbookapp.repository.AddressbookRepository;

public class AddressbookAppService {
	
	@Autowired
	AddressbookRepository repo;

	public ContactDetails  saveDataInDB(RequestDTO dto) {
		ContactDetails newContact = new ContactDetails(dto);
		repo.save(newContact);
		return newContact;
	}

	public ContactDetails findContactById(Integer id) {
		ContactDetails contact = repo.getById(id);
		return contact;
	}

	public ContactDetails updateDateById(Integer id, RequestDTO dto) {
		ContactDetails newContact = new ContactDetails(id,dto);
		repo.save(newContact);
		return newContact;
	}

	public void deleteContact(Integer id) {
		repo.deleteById(id);
	}
}
