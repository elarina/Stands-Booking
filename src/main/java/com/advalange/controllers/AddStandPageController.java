package com.advalange.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.advalange.jdbc.DataSourceConfig;
import com.advalange.jdbc.JDBCController;
import com.advalange.model.Stand;

@Controller
public class AddStandPageController {
	
	private JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());
	
	@GetMapping("/addStand") 
	public String showAddStandsPage(Model model) {
		model.addAttribute("stand", new Stand());
		return "addStand";
	}
	
	@PostMapping(value = "/addStand")
	public String addStand(@ModelAttribute Stand stand, Model model) {
		System.out.println(stand);
		System.out.println(stand.getId());
		controller.addStand(stand);	
		return "redirect:/stands";
	}
	
	@PostMapping(value = "/addStand", params = "cancel")
	public String cancelAddStand(@ModelAttribute Stand stand, Model model) {
		return "redirect:/addStand";
	}
}
