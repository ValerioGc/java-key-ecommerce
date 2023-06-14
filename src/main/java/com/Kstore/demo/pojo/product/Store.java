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
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	@Column
	private String name;
	
	@Column 
	private String logo;

	@OneToMany
	private List<Videogame> videogames;
	
	public Store() {}	
	public Store(String name) {
		setName(name);
	}	
	public Store(String name, String logo) {
		setName(name);
		setLogo(logo);
	}	
	public Store(String name, Videogame videogame) {
		setName(name);
		setVideogames(videogame);
	}	
	
	public Store(String name, String logo, Videogame videogame) {
		setName(name);
		setLogo(logo);
		setVideogames(videogame);
	}	
	
//  ------------------------------ Getter & Setters -------------------------
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	


	public List<Videogame> getVideogames() {
		return videogames;
	}
	public void setVideogames(Videogame videogame) {
		this.videogames.add(videogame);
	}


	@Override
	public String toString(){
		return "\n Videogame: " + getName()
				+ "\nLogo: " + getLogo();
	}
}
