package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.Software;
import com.Kstore.demo.repo.SoftwareRepo;

@Service
public class SoftwareService {
	
	@Autowired
	private SoftwareRepo softwareRepo;
	
	public List<Software> findAll() {	
		return softwareRepo.findAll();
	}
	
	public Software save(Software software) {	
		return softwareRepo.save(software);
	}
	
	public Optional<Software> findById(int id) {	
		return softwareRepo.findById(id);
	}
	
	public String delete(Software software) {
		
		softwareRepo.delete(software);
		
		return "200";
	}
	
	public List<Software> findByTitle(String name) {	
		return softwareRepo.findByNameContaining(name);
	}
}
