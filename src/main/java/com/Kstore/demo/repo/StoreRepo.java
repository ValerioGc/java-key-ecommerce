package com.Kstore.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kstore.demo.pojo.product.Store;

public interface StoreRepo extends JpaRepository<Store, Integer> {

//	List<Store> findByNameContaining(String name);

}
