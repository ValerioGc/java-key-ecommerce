package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.user.Admin;
import com.Kstore.demo.pojo.user.Customer;
import com.Kstore.demo.repo.AdminRepo;
import com.Kstore.demo.repo.CustomerRepo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	public List<Admin> findAll() {	
		return adminRepo.findAll();
	}
	
	public Admin save(Admin admin) {	
		return adminRepo.save(admin);
	}
	
	public Optional<Admin> findById(int id) {	
		return adminRepo.findById(id);
	}
	
	public List<Admin> findByUserName(String userName) {	
		return adminRepo.findByUserNameContaining(userName);
	}
}
