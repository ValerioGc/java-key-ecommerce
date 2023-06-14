package com.Kstore.demo.pojo.product;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table
@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String image;
	
	@OneToMany
	private List<Videogame> videogames;

//  --------------------------------------- Constructors  -------------------------------------
	public Publisher() { }
	
	public Publisher(String name) {
		setName(name);
	}
	
	public Publisher(String name, Videogame videogame) {
		setName(name);
	}
	
	public Publisher(String name, String image) {
		setName(name);
		setImage(image);
	}
	public Publisher(String name, String image, Videogame videogame) {
		setName(name);
		setImage(image);
		setVideogames(videogame);
	}
	
//  --------------------------------------- Getter & Setters ----------------------------------
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public List<Videogame> getVideogames() {
		return videogames;
	}
	
	public void setVideogames(Videogame videogame) {
		this.videogames.add(videogame);
	}
	
	
	
	@Override
	public String toString() {
		return "\n Publisher: " + getName();
	}
}
