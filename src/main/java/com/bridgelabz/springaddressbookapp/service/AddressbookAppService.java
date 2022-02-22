package com.bridgelabz.springaddressbookapp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springaddressbookapp.contactmodel.AddressbookModel;
import com.bridgelabz.springaddressbookapp.dto.AddressbookDTO;
import com.bridgelabz.springaddressbookapp.repository.AddressbookRepository;


@Service
public class AddressbookAppService {
	
	@Autowired
	AddressbookRepository repo;

	public AddressbookModel  saveDataInDB(AddressbookDTO dto) {
		AddressbookModel newContact = new AddressbookModel(dto);
		repo.save(newContact);
		return newContact;
	}

	public List<AddressbookModel> getListOfContacts() {
		List<AddressbookModel> allDataInAddressbook = repo.findAll();
		return allDataInAddressbook;
	}
	
	/*public AddressbookModel getContactById(Integer id) {
		AddressbookModel newContact = repo.getById(id);
		System.out.println(newContact);
		return newContact;
	}*/
	
	public Optional<AddressbookModel> getContactbyId(Integer id) {
		return repo.findById(id);
	}

	public AddressbookModel updateDateById(Integer id, AddressbookDTO dto) {
		AddressbookModel newContact = new AddressbookModel(id,dto);
		repo.save(newContact);
		return newContact;
	}

	public void deleteContact(Integer id) {
		repo.deleteById(id);
	}
}
