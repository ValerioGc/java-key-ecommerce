package com.Kstore.demo.pojo.product;

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

	@ManyToMany
	private List<Category> categories;
	
	// ------------------------------------------- Constructors --------------------------------------------------------
	
	public Software() {}
	public Software(String name) {
		setName(name);
	}
	
	public Software(String name, int price) {
		setName(name);
		setPrice(price);
	}
	
	public Software(String name, Category category) {
		setName(name);
		setCategory(category);
	}
	
	public Software(String name, Category category, int price) {
		setName(name);
		setCategory(category);
		setPrice(price);
	}
	
	public Software(String name, int price, String description) {
		setName(name);
		setPrice(price);
		setDescription(description);
	}
	
	public Software(String name, int price, String description, Category category) {
		setName(name);
		setPrice(price);
		setDescription(description);
		setCategory(category);
	}
	
	// -------------------------------------------- Getters&Setters -----------------------------------------------------
	
	public int getId() {
		return id;
	}
	
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
	
// -------------------------------- G & S Relations ------------------------------
	
//  ---- Categories ----
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategory(Category category) {
		this.categories.add(category);
	}
	
	
	@Override
	public String toString() {
		return "\nID: " + getId()
				+ "\nName: " + getName()
				+ "\nDescription: " + getDescription()
				+ "\nPrice: " + getPrice();
	}
	
}
