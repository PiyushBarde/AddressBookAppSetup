package com.bridgelabz.springaddressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.springaddressbookapp.contactmodel.ContactDetails;

public interface AddressbookRepository extends JpaRepository<ContactDetails, Integer>{

}
