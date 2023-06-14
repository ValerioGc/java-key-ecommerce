package com.Kstore.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Kstore.demo.pojo.product.Videogame;
import com.Kstore.demo.service.VideogameService;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class ApiSearchController {

	@Autowired
	VideogameService videogameService;
	
//  Ricerca giochi per nome ---------------------------------------------------------------------
	@GetMapping("/{query}")
	public List<Videogame> searchVideogameByTitle(@PathVariable("query") String q) {
		
		List<Videogame> videogameSrc = ( 
				( q.equals(null)) || (q.equals(" ")) ) ? 
				videogameService.findAll() : 
				videogameService.findByTitle(q);
		
		return videogameSrc;
 	}
}
