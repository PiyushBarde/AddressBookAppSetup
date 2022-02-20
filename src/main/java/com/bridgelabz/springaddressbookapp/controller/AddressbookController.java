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
import com.bridgelabz.springaddressbookapp.dto.RequestDTO;
import com.bridgelabz.springaddressbookapp.service.AddressbookAppService;

@RestController
@RequestMapping("/contactbook")
public class AddressbookController {
	
	@Autowired
	AddressbookAppService service;
	
	@GetMapping("")
	public String welcomeUser() {
		return "Welcome to the addressbook app";
	}
	
	@PostMapping("/post")
	public ResponseEntity<ContactDetails> postData(@RequestBody RequestDTO dto) {
		ContactDetails newContact = service.saveDataInDB(dto);
		return new ResponseEntity<ContactDetails>(newContact,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ContactDetails> retriveData(@PathVariable Integer id){
		ContactDetails newContact = service.findContactById(id);
		return new ResponseEntity<ContactDetails>(newContact,HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<ContactDetails> updateById(@PathVariable Integer id, @RequestBody RequestDTO dto){
		ContactDetails newContact = service.updateDateById(id,dto);
		return new ResponseEntity<ContactDetails>(newContact,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteDataById(@PathVariable Integer id){
		service.deleteContact(id);
		return new ResponseEntity<String>("Contact deleted succesfully",HttpStatus.OK);
	}
}
