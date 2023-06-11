package com.Kstore.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kstore.demo.pojo.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	List<Category> findByNameContaining(String name);

}
