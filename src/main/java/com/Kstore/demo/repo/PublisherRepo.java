package com.Kstore.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Kstore.demo.pojo.product.Publisher;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {

	List<Publisher> findByNameContaining(String name);

}
