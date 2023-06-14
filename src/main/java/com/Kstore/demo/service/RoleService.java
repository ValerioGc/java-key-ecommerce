package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.user.Admin;
import com.Kstore.demo.pojo.user.Customer;
import com.Kstore.demo.pojo.user.Role;
import com.Kstore.demo.repo.AdminRepo;
import com.Kstore.demo.repo.CustomerRepo;
import com.Kstore.demo.repo.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	public List<Role> findAll() {	
		return roleRepo.findAll();
	}
	
	public Role save(Role role) {	
		return roleRepo.save(role);
	}
	
	public Optional<Role> findById(int id) {	
		return roleRepo.findById(id);
	}
	
	public List<Role> findByName(String name) {	
		return roleRepo.findByNameContaining(name);
	}
}
