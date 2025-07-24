package com.larina.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.larina.model.Stand;
import com.larina.repositories.StandsRepository;

@Controller
public class StandsPageController {

	private final StandsRepository standsRepository;
	
	public StandsPageController(StandsRepository standsRepository) {
		this.standsRepository = standsRepository;
	}
	
	@GetMapping("/stands")
	public String showStandsPage(Model model) {
		addStands(model);
		return "stands";
	}

	private void addStands(Model model) {
		List<Stand> stands = standsRepository.findAll();
		List<Integer> standIds = new ArrayList<>();
		model.addAttribute("stands", stands);
		model.addAttribute("stand_ids", standIds);
	}

	@PostMapping(value = "/stands", params = "delete")
	public String removeStand(@RequestParam(value = "stand_ids", required = false) long[] ids, Model model) {
		System.out.println("delete");
		if (ids == null) {
			return "redirect:/stands";
		}
		for (long id : ids) {
			Optional<Stand> standOpt = standsRepository.findById(id);
			if(standOpt.isPresent()) {
				standsRepository.delete(standOpt.get());
			}
		}
		return "redirect:/stands";
	}

	@PostMapping(value = "/stands", params = "cancel")
	public String cancelRemove(Model model) {
		System.out.println("cancel");
		return "redirect:/stands";
	}

}