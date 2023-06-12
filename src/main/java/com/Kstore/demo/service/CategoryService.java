package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.product.Category;
import com.Kstore.demo.pojo.user.Customer;
import com.Kstore.demo.repo.CategoryRepo;
import com.Kstore.demo.repo.CustomerRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> findAll() {	
		return categoryRepo.findAll();
	}
	
	public Category save(Category category) {	
		return categoryRepo.save(category);
	}
	
	public Optional<Category> findById(int id) {	
		return categoryRepo.findById(id);
	}
	
	public String delete(Category category) {
		
		categoryRepo.delete(category);
		
		return "200";
	}
	
	public List<Category> findByTitle(String name) {	
		return categoryRepo.findByNameContaining(name);
	}
}
