package com.larina.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.larina.model.Stand;
import com.larina.model.StandsGroup;
import com.larina.repositories.StandGroupRepository;
import com.larina.repositories.StandsRepository;

@Controller
public class AddStandPageController {

	private final StandGroupRepository standGroupRepository;

	private final StandsRepository standsRepository;

	public AddStandPageController(StandsRepository standsRepository, StandGroupRepository standGroupRepository) {
		this.standsRepository = standsRepository;
		this.standGroupRepository = standGroupRepository;
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
		Optional<StandsGroup> mainGroup = standGroupRepository.findAll().stream()
				.filter(sg -> sg.getName().equals("All Stands") || sg.getId().equals(1)).findFirst();
		if (mainGroup.isPresent()) {
			stand.setGroup(mainGroup.get());
		}
		standsRepository.save(stand);
		return "redirect:/stands";
	}

	@PostMapping(value = "/addStand", params = "cancel")
	public String cancelAddStand(@ModelAttribute Stand stand, Model model) {
		return "redirect:/addStand";
	}
}
