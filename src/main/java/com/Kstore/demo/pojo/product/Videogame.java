package com.Kstore.demo.pojo.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
//  --------------------------------------- Relations ------------------------------------------
	@ManyToMany
	@JsonIgnore
	private List<Category> categories = new ArrayList<Category>();
	
	@ManyToMany
	@JsonIgnore
	private List<Platform> platforms;	
	
	
	@ManyToOne
	@JoinColumn(nullable = true)
	@JsonIgnore
	private Publisher publisher;	

	@ManyToOne
	@JoinColumn(nullable = true)
	@JsonIgnore
	private Store store;	
	
	
//  --------------------------------------- Constructors ----------------------------------
	
	public Videogame() { }
	
	public Videogame(
				String name, 
				String release_date
			) 
		{
		setName(name);
		setRelease_date(release_date);
	}
	
	public Videogame(
				String name, 
				String overview, 
				String release_date,
				String cover
			)
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
				Store store
			)
		{
		
		setName(name);
		setOverview(overview);
		setRelease_date(release_date);
		setCover(cover);
		setStore(store);
	}
	
	public Videogame(
				String name, 
				String overview, 
				String release_date,
				String cover,
				Platform platform
			)
		{
		
		setName(name);
		setOverview(overview);
		setRelease_date(release_date);
		setCover(cover);
		setPlatform(platform);
	}
	
	public Videogame(
				String name, 
				String overview, 
				String release_date,
				String cover,
				Category category
			)
	{
		
		setName(name);
		setOverview(overview);
		setRelease_date(release_date);
		setCover(cover);
//		setCategories(category);
		this.categories.add(category);
	}
	
	public Videogame(
			String name, 
			String overview, 
			String release_date,
			String cover,
			Publisher publisher
			)
	{
		
		setName(name);
		setOverview(overview);
		setRelease_date(release_date);
		setCover(cover);
		setPublisher(publisher);
	}
	
	public Videogame(
				String name, 
				String overview, 
				String release_date,
				String cover,
				Category category,
				Platform platform,
				Store Store,
				Publisher publisher
			)
	{
		
		setName(name);
		setOverview(overview);
		setRelease_date(release_date);
		setCover(cover);
		setPublisher(publisher);
		setPlatform(platform);
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
	
// -------------------------------- G & S Relations ------------------------------
	
//  ---- Categories ----
	public void setCategories(Category category) {
		this.categories.add(category);
	}
	public List<Category> getCategories() {
		return categories;
	}	
	
//  ---- Platform ----
	public void setPlatform(Platform platform) {
		this.platforms.add(platform);
	}
	public List<Platform> getPlatforms() {
		return platforms;
	}
	
//  ---- Publisher ----
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

//  ---- Store ----
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
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