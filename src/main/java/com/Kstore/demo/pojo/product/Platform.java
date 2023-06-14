package com.Kstore.demo.pojo.product;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table
@Entity
public class Platform {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String image;
	
	@ManyToMany(mappedBy = "platforms", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Videogame> videogames;
	
	
//  --------------------------------------- Constructors ---------------------------------------
	public Platform() { }
	public Platform(String name) {
		setName(name);
	}
	public Platform(String name, String image) {
		setName(name);
		setImage(image);
	}
	public Platform(String name, Videogame videogame) {
		setName(name);
		setVideogames(videogame);
	}
	public Platform(String name, String image, Videogame videogame) {
		setName(name);
		setImage(image);
		setVideogames(videogame);
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
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
// -------------------------------- G & S Relations ------------------------------
	
//  ---- Videogames ----
	public List<Videogame> getVideogames() {
		return videogames;
	}
	public void setVideogames(Videogame videogame) {
		this.videogames.add(videogame);
	}
	

	
	@Override
	public String toString() {
		return "\n Platform: " + getName()
				+ "\n Image: " + getImage();
	}
}
