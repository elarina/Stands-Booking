package com.larina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.larina.model.Stand;
import com.larina.repositories.StandsRepository;

@Controller
public class AddStandPageController {
	
	private final StandsRepository standsRepository;
	
	public AddStandPageController(StandsRepository standsRepository) {
		this.standsRepository = standsRepository;
	}
	
	@GetMapping("/addStand") 
	public String showAddStandsPage(Model model) {
		model.addAttribute("stand", new Stand());
		return "addStand";
	}
	
	@PostMapping(value = "/addStand")
	public String addStand(@ModelAttribute Stand stand, Model model) {
		System.out.println(stand);
		System.out.println(stand.getId());
		standsRepository.save(stand);	
		return "redirect:/stands";
	}
	
	@PostMapping(value = "/addStand", params = "cancel")
	public String cancelAddStand(@ModelAttribute Stand stand, Model model) {
		return "redirect:/addStand";
	}
}
