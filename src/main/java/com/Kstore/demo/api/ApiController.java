package com.Kstore.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Kstore.demo.pojo.product.Category;
import com.Kstore.demo.pojo.product.Software;
import com.Kstore.demo.pojo.product.Videogame;
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
		List<Category> cat = categoryService.findAll();
		List<Videogame> vdg = videogameService.findAll();
		List<Software> stw = softwareService.findAll();
		
		return  "\n KeySHop app V1" + "\n Numero Videogiochi: " + vdg.size() + 
				"\n Categorie: " + cat.size() +
				"\n Software: " + stw.size();
	}
	
//  Videogames  ---------------------------------------------------------------------------------
	@GetMapping("/list/videogames")
	public List<Videogame> getVideogames() {
		List<Videogame> vdg = videogameService.findAll();
		return vdg;
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
