package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.user.Customer;
import com.Kstore.demo.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public List<Customer> findAll() {	
		return customerRepo.findAll();
	}
	
	public Customer save(Customer customer) {	
		return customerRepo.save(customer);
	}
	
	public Optional<Customer> findById(int id) {	
		return customerRepo.findById(id);
	}
	
	public List<Customer> findByUserName(String userName) {	
		return customerRepo.findByUserNameContaining(userName);
	}
}
