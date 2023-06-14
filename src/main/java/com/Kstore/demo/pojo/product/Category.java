package com.Kstore.demo.pojo.product;


import java.util.List;

import jakarta.persistence.CascadeType;
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
	
	@ManyToMany(mappedBy = "categories", cascade = CascadeType.REMOVE)
	private List<Videogame> videogames;
	
	@ManyToMany(mappedBy = "categories", cascade = CascadeType.REMOVE)
	private List<Software> software;
	
	
//  --------------------------------------- Constructors ----------------------------------
	
	public Category() {}
	public Category(String name) {
		setName(name);
	}
	
	public Category(String name, Videogame videogame) {
		setName(name);
		setVideogame(videogame);
	}
	
	public Category(String name, Software software) {
		setName(name);
		setSoftware(software);
	}
	
	public Category(String name, Videogame videogame, Software software) {
		setName(name);
		setVideogame(videogame);
		setSoftware(software);
	}
	
	
//  --------------------------------------- Getter & Setters ----------------------------------
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
// -------------------------------- G & S Relations ------------------------------
	
//  ---- Videogames ----
	public List<Videogame> getVideogames() {
		return videogames;
	}
	public void setVideogame(Videogame videogames) {
		this.videogames.add(videogames);
	}
	
//  ---- Software ----
	public List<Software> getSoftware() {
		return software;
	}
	public void setSoftware(Software software) {
		this.software.add(software);
	}
	
	
	@Override
	public String toString() {
		return "\nCategory id:" + getId() 
				+ "\nName:" + getName()
				+ "\nVideogames: " + getVideogames()
				+ "\nSoftware: " + getSoftware();
	}
}
