package com.Kstore.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Kstore.demo.pojo.Category;
import com.Kstore.demo.pojo.Software;
import com.Kstore.demo.pojo.Videogame;
import com.Kstore.demo.service.CategoryService;
import com.Kstore.demo.service.SoftwareService;
import com.Kstore.demo.service.VideogameService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiController {

	
	@Autowired
	VideogameService videogameService;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SoftwareService softwareService;
	
//  Categories ----------------------------------------------------------------------------------
	@GetMapping("/info")
	public String getInfo() {
		String appV = "KeySHop app V1";
		
		return appV;
	}
	
//  Videogames  ---------------------------------------------------------------------------------
	@GetMapping("/list/videogames")
	public List<Videogame> getVideogames() {
		List<Videogame> vdg = videogameService.findAll();
		return vdg;
	}
	
//  Ricerca giochi per nome ---------------------------------------------------------------------
	@GetMapping("/search/{query}")
	public List<Videogame> searchVideogameByTitle(@PathVariable("query") String q) {
		
		List<Videogame> videogameSrc = ( 
				( q.equals(null)) || (q.equals(" ")) ) ? 
				videogameService.findAll() : 
				videogameService.findByTitle(q);
		
		return videogameSrc;
 	}
	
	//  Categories ------------------------------------------------------------------------------
	@GetMapping("/list/categories")
	public List<Category> getCategories() {
		List<Category> vdg = categoryService.findAll();
		return vdg;
	}
	
	//  Software --------------------------------------------------------------------------------
	@GetMapping("/list/software")
	public List<Software> getSoftware() {
		List<Software> vdg = softwareService.findAll();
		return vdg;
	}
	

}
