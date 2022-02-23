package com.bridgelabz.springaddressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.springaddressbookapp.contactmodel.AddressbookModel;

public interface AddressbookRepository extends JpaRepository<AddressbookModel, Integer>{
}
