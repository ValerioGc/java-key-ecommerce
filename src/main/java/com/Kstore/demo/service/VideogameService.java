package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.Customer;
import com.Kstore.demo.pojo.Videogame;
import com.Kstore.demo.repo.CustomerRepo;
import com.Kstore.demo.repo.VideogameRepo;

@Service
public class VideogameService {
	
	@Autowired
	private VideogameRepo videogameRepo;
	
	public List<Videogame> findAll() {	
		return videogameRepo.findAll();
	}
	
	public Videogame save(Videogame videogame) {	
		return videogameRepo.save(videogame);
	}
	
	public Optional<Videogame> findById(int id) {	
		return videogameRepo.findById(id);
	}
	
	public String delete(Videogame videogame) {
		
		videogameRepo.delete(videogame);
		
		return "200";
	}
	
	public List<Videogame> findByTitle(String name) {	
		return videogameRepo.findByNameContaining(name);
	}
}
