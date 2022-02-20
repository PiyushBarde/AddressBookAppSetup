package com.bridgelabz.springaddressbookapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contactbook")
public class AddressbookController {
	@GetMapping("")
	public String welcomeUser() {
		return "Welcome to the addressbook app";
	}
}
