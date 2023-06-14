package com.Kstore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kstore.demo.pojo.product.Platform;
import com.Kstore.demo.pojo.product.Store;
import com.Kstore.demo.pojo.user.Admin;
import com.Kstore.demo.pojo.user.Customer;
import com.Kstore.demo.repo.AdminRepo;
import com.Kstore.demo.repo.CustomerRepo;
import com.Kstore.demo.repo.PlatformRepo;
import com.Kstore.demo.repo.StoreRepo;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepo storeRepo;
	
	public List<Store> findAll() {	
		return storeRepo.findAll();
	}
	
	public Store save(Store store) {	
		return storeRepo.save(store);
	}
	
	public Optional<Store> findById(int id) {	
		return storeRepo.findById(id);
	}
	
//	public List<Store> findByName(String name) {	
//		return storeRepo.findByNameContaining(name);
//	}
}
