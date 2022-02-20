package com.bridgelabz.springaddressbookapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springaddressbookapp.contactmodel.ContactDetails;
import com.bridgelabz.springaddressbookapp.dto.RequestDTO;
import com.bridgelabz.springaddressbookapp.repository.AddressbookRepository;


@Service
public class AddressbookAppService {
	
	@Autowired
	AddressbookRepository repo;

	public ContactDetails  saveDataInDB(RequestDTO dto) {
		ContactDetails newContact = new ContactDetails(dto);
		repo.save(newContact);
		return newContact;
	}

	public ContactDetails getContactById(Integer id) {
		ContactDetails newContactDetails = repo.getById(id);
		return newContactDetails;
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
