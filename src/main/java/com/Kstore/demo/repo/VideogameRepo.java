package com.Kstore.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kstore.demo.pojo.product.Videogame;

public interface VideogameRepo extends JpaRepository<Videogame, Integer> {

	List<Videogame> findByNameContaining(String name);

}
