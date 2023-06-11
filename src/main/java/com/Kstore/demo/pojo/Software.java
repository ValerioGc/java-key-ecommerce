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
public class Software {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int price;
	
	@Column
	private String description;
	
	@ManyToMany(mappedBy = "software")
	private List<Category> categories;
	
	// ------------------------------------------- Constructors --------------------------------------------------------
	
	public Software() {}
	public Software(String name) {
		
	}
	public Software(String name, int price, String description) {
		
	}
	
	// -------------------------------------------- Getters&Setters -----------------------------------------------------
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	
	
}
