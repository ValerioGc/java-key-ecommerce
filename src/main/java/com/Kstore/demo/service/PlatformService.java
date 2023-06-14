package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.product.Platform;
import com.Kstore.demo.pojo.user.Admin;
import com.Kstore.demo.pojo.user.Customer;
import com.Kstore.demo.repo.AdminRepo;
import com.Kstore.demo.repo.CustomerRepo;
import com.Kstore.demo.repo.PlatformRepo;

@Service
public class PlatformService {
	
	@Autowired
	private PlatformRepo platformRepo;
	
	public List<Platform> findAll() {	
		return platformRepo.findAll();
	}
	
	public Platform save(Platform platform) {	
		return platformRepo.save(platform);
	}
	
	public Optional<Platform> findById(int id) {	
		return platformRepo.findById(id);
	}
	
	public List<Platform> findByName(String name) {	
		return platformRepo.findByNameContaining(name);
	}
}
