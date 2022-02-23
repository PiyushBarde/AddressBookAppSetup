package com.bridgelabz.springaddressbookapp.service;

import java.util.List;

import com.bridgelabz.springaddressbookapp.contactmodel.AddressbookModel;
import com.bridgelabz.springaddressbookapp.dto.AddressbookDTO;

public interface IAddressbookAppService {
	public AddressbookModel  saveAddress(AddressbookDTO dto);
	
	public List<AddressbookModel> getListOfAddresses();
	
	public AddressbookModel getAddressbyId(Integer id);
	
	public AddressbookModel updateDateById(Integer id, AddressbookDTO dto);
	
	public void deleteContact(Integer id);
}
