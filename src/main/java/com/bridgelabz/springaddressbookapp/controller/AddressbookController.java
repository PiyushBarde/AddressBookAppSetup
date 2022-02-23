package com.bridgelabz.springaddressbookapp.controller;

import java.util.List;
import javax.validation.Valid;
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
import com.bridgelabz.springaddressbookapp.contactmodel.AddressbookModel;
import com.bridgelabz.springaddressbookapp.dto.AddressbookDTO;
import com.bridgelabz.springaddressbookapp.dto.ResponseDTO;
import com.bridgelabz.springaddressbookapp.service.AddressbookAppService;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {
	
	@Autowired
	AddressbookAppService service;
	
	@GetMapping("")
	public String welcomeUser() {
		return "Welcome to the addressbook app";
	}
	@GetMapping("/get")
	public ResponseEntity<String>getAllData(){
		List<AddressbookModel> listOfContacts = service.getListOfAddresses();
		ResponseDTO response = new ResponseDTO("Addresbook :", listOfContacts);
		return new ResponseEntity(response,HttpStatus.OK);
	}
	@PostMapping("/post")
	public ResponseEntity<ResponseDTO> postData(@Valid @RequestBody AddressbookDTO dto) {
		AddressbookModel newContact = service.saveAddress(dto);
		ResponseDTO response = new ResponseDTO("New Contact Added in Addressbook : ", newContact);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public  ResponseEntity<AddressbookModel> retriveData(@PathVariable Integer id){
		ResponseDTO response = new ResponseDTO("Addressbook of given id: ",service.getAddressbyId(id));
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer id,@Valid @RequestBody AddressbookDTO dto){
		AddressbookModel newContact = service.updateDateById(id,dto);
		ResponseDTO response = new ResponseDTO("Addressbook updated : ", newContact);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteDataById(@PathVariable Integer id){
		service.deleteContact(id);
		return new ResponseEntity<String>("Contact deleted succesfully",HttpStatus.OK);
	}
}
