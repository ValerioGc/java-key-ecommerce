package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.product.Publisher;
import com.Kstore.demo.repo.PublisherRepo;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepo publisherRepo;
	
	public List<Publisher> findAll() {	
		return publisherRepo.findAll();
	}
	
	public Publisher save(Publisher publisher) {	
		return publisherRepo.save(publisher);
	}
	
	public Optional<Publisher> findById(int id) {	
		return publisherRepo.findById(id);
	}
	
	public List<Publisher> findByName(String name) {	
		return publisherRepo.findByNameContaining(name);
	}
}
