package com.Kstore.demo.pojo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Videogame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@NonNull
	private String name;
	
	@Column(nullable = true)
	private String overview;
	
	@Column(nullable = true)
	private String cover;
	
	@Column(nullable = false)
	private LocalDate release_date;
	
	@ManyToMany(mappedBy = "videogames")
	private List<Category> categories;
	
	
	public Videogame() { }
	
	public Videogame(
			String name, 
			String overview, 
			String release_date,
			String cover)
		{
		
		setName(name);
		setOverview(overview);
		setRelease_date(release_date);
		setCover(cover);
	}
	
	public Videogame(
			String name, 
			String overview, 
			String release_date,
			String cover,
			Category category)
		{
		
		setName(name);
		setOverview(overview);
		setRelease_date(release_date);
		setCover(cover);
		setCategories(category);
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

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public LocalDate getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = LocalDate.parse(release_date);
	}

	public String getCover() {
		return cover;
	}
	
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	// -------------------------------- Relations ------------------------------
	
	public void setCategories(Category category) {
		categories.add(category.getId(), category);
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	@Override
	public String toString() {
		return "id " + getId() 
				+ "\nName " + getName() 
				+ "\nRelease Date: " + getRelease_date() 
				+ "\nOverview: " + getOverview() 
				+ "\nCover: " + getCover();
	}
}
