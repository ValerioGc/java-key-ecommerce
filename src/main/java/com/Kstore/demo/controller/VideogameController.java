package com.Kstore.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Kstore.demo.pojo.product.Category;
import com.Kstore.demo.pojo.product.Videogame;
import com.Kstore.demo.service.CategoryService;
import com.Kstore.demo.service.VideogameService;



@Controller
@RequestMapping("/videogames")
public class VideogameController {
	
	@Autowired
	private VideogameService videogameService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public String getVideoGames(Model model) {
		
		List<Videogame> vdg = videogameService.findAll();
		
		model.addAttribute("videogames", vdg);
		
		return "videogames/videogames";
		
	}
	
	@GetMapping("/show/{id}")
	public String getGameInfo(@PathVariable("id") int id, Model model) throws Exception {
		
		try {
			Videogame vdg = videogameService.findById(id).get();
			
			model.addAttribute("vdg", vdg);
		}
		catch(Exception err) {
			System.err.println("Errore:" + err);
		}
		return "videogames/details";
	}
	
// Create ------------------------------------------------------------------------------------------
	
	@GetMapping("/create")
	public String createNewVideogame(Model model) {
		
		Videogame vdg = new Videogame();
		List<Category> cat = categoryService.findAll();
		
		model.addAttribute("obj", vdg);
		model.addAttribute("categories", cat);
		model.addAttribute("title", "Create New Videogame");
		
		return "videogames/new";
	}
	
	@PostMapping("/create")
	public String storeNewVideogame(
										@Validated @ModelAttribute("videogame")
										Videogame videogame,
										BindingResult bindingResult, 
										RedirectAttributes redirectAttributes ) throws Exception {
		try {
			
			videogameService.save(videogame);
		}
		catch(Error err) {
			
			System.err.println("Errore: " + err);
			throw new Exception();
		}
		
		return "redirect:/videogames/list";		
		
	}
	
	// Edit --------------------------------------
		@GetMapping("/edit/{id}")
		public String editVideogame(Model model, @PathVariable("id") int id) {
			
			Optional<Videogame> vdg = videogameService.findById(id);
			
			model.addAttribute("obj", vdg);
			
			return "videogames/edit";
		}
		
		
		@PostMapping("/edit")
		public String updateVideogame(
										@Validated @ModelAttribute("videogame")
										Videogame videogame,
										BindingResult bindingResult, 
										RedirectAttributes redirectAttributes) throws Exception {
			if (bindingResult.hasErrors()) {
				redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
				throw new Exception();
			} else {
				redirectAttributes.addFlashAttribute("msg", "Ok");
				
			}
			
			
			return "redirect:/list";
		}
		
		
		
	// Delete -----------------------------------------------------------------------------
		
		@GetMapping("/delete/{id}")
		public String deleteVideogame(@PathVariable("id") int id) throws Exception  {
			try {
				Videogame target = videogameService.findById(id).get();
				
				videogameService.delete(target);
			}
			catch(Error err) {
				System.err.println("Errore: " + err);
				throw new Exception(err);
			}
			
			return "redirect:/list";
		}

	
}
