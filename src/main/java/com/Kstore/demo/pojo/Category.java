package com.Kstore.demo.pojo;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table
@Entity
public class Category {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
//	@NotEmpty(message = "Il nome della categoria non deve essere vuoto")
	private String name;
	
	@ManyToMany
	private List<Videogame> videogames;
	
	@ManyToMany
	private List<Software> software;
	
	// Constructors --------------------------------------------------------
	public Category() {}
	public Category(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	
	
}
