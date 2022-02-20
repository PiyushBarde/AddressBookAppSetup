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
import com.bridgelabz.springaddressbookapp.dto.ResponseDTO;
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
	public ResponseEntity<ResponseDTO> postData(@RequestBody RequestDTO dto) {
		ContactDetails newContact = service.saveDataInDB(dto);
		ResponseDTO response = new ResponseDTO("New Contact Added in Addressbook : ", newContact);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<String> retriveData(@PathVariable Integer id){
		ContactDetails newContact = service.getContactById(id);
		return new ResponseEntity<String>(newContact.toString(),HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer id, @RequestBody RequestDTO dto){
		ContactDetails newContact = service.updateDateById(id,dto);
		ResponseDTO response = new ResponseDTO("Contact in Addressbook : ", newContact);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteDataById(@PathVariable Integer id){
		service.deleteContact(id);
		return new ResponseEntity<String>("Contact deleted succesfully",HttpStatus.OK);
	}
}
