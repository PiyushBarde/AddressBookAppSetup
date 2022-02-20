package com.bridgelabz.springaddressbookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springaddressbookapp.contactmodel.ContactDetails;
import com.bridgelabz.springaddressbookapp.repository.AddressbookRepository;

@RestController
@RequestMapping("/contactbook")
public class AddressbookController {
	@Autowired
	AddressbookRepository repo;
	
	@GetMapping("")
	public String welcomeUser() {
		return "Welcome to the addressbook app";
	}
	
	@PostMapping("/post")
	public ResponseEntity<ContactDetails> postData(@RequestBody ContactDetails contact) {
		ContactDetails newContact = new ContactDetails(contact);
		repo.save(newContact);
		return new ResponseEntity<ContactDetails>(newContact,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ContactDetails> retriveData(@PathVariable Integer id, @RequestBody ContactDetails contact){
		ContactDetails newContact = repo.getById(id);
		return new ResponseEntity<ContactDetails>(newContact,HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<ContactDetails> updateById(@PathVariable Integer id, @RequestBody ContactDetails contact){
		ContactDetails newContact = new ContactDetails(id, contact);
		repo.save(newContact);
		return new ResponseEntity<ContactDetails>(newContact,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteDataById(@PathVariable Integer Id){
		repo.deleteById(Id);
		return new ResponseEntity<String>("Contact deleted succesfully",HttpStatus.OK);
	}
}
