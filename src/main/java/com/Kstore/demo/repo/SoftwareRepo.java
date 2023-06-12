package com.Kstore.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kstore.demo.pojo.product.Software;


public interface SoftwareRepo extends JpaRepository<Software, Integer> {

	List<Software> findByNameContaining(String name);

}
