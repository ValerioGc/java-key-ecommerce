package com.Kstore.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Kstore.demo.pojo.Customer;
import com.Kstore.demo.pojo.Videogame;
import com.Kstore.demo.service.CustomerService;
import com.Kstore.demo.service.VideogameService;

@Controller
public class MainController {
		
	@Autowired
	private CustomerService customerService;
	@Autowired
	private VideogameService videogameService;
	
	@GetMapping("/") 
	public String getHome(Model model, Authentication
			authentication)	{
		
		List<Customer> cmrs = customerService.findAll();

		List<Videogame> vdg = videogameService.findAll();
		
		model.addAttribute("videogames", vdg);
	// Model attribute -------------------------------------------
		model.addAttribute("cs", cmrs);
		model.addAttribute("title", "Home");
		model.addAttribute("loggedUser", authentication.getName());
		
		
		return "home";
	}
	
//	@GetMapping("/src/${query}")
//	public String getGameInfo(@ModelAttribute String query) {
//		return null;
//	}
	
	@GetMapping("/customers") 
	public String getCustomers(Model model)	{
		model.addAttribute("title", "Games");
		
		return "customer_details";
	}
}
