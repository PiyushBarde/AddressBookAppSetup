package com.bridgelabz.springaddressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringaddressbookappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaddressbookappApplication.class, args);
		log.info("Addressbook App started");
	}
}
