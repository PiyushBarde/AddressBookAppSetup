package com.bridgelabz.springaddressbookapp.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.springaddressbookapp.contactmodel.AddressbookModel;
import com.bridgelabz.springaddressbookapp.dto.AddressbookDTO;
import com.bridgelabz.springaddressbookapp.exceptions.AddressbookAppException;
import com.bridgelabz.springaddressbookapp.repository.AddressbookRepository;


@Service
public class AddressbookAppService implements IAddressbookAppService{
	
	@Autowired
	AddressbookRepository repo;

	public AddressbookModel  saveAddress(AddressbookDTO dto) {
		AddressbookModel address = new AddressbookModel(dto);
		repo.save(address);
		return address;
		
	}
	
	public List<AddressbookModel> getListOfAddresses() {
		List<AddressbookModel> list = repo.findAll();
		if(list.isEmpty()) {
			throw new AddressbookAppException("Addressbook is empty");
		}
		else {
		return list;
		}
	}
	
	public AddressbookModel getAddressbyId(Integer id) {
		List<AddressbookModel> allAddresses = repo.findAll();
		AddressbookModel address = allAddresses.stream()
				.filter(addressBookData->addressBookData.getId()==id)
				.findFirst()
				.orElseThrow(()-> new AddressbookAppException("Employee Not found"));
		return address;
	}

	public AddressbookModel updateDateById(Integer id, AddressbookDTO dto) {
		Optional<AddressbookModel> address = repo.findById(id);
		if(address.isPresent()) {
			System.out.println("ID is valid");
			AddressbookModel newAddress = new AddressbookModel(id,dto);
			repo.save(newAddress);
			return newAddress;
		}
		else {
			throw new AddressbookAppException("Employee not found");
		}
	}

	public void deleteContact(Integer id) {
		Optional<AddressbookModel> address = repo.findById(id);
		if(address.isPresent()) {
			repo.deleteById(id);
		}
		else {
			 throw new AddressbookAppException("Invalid id..please input valid id");
		}
	}
}
