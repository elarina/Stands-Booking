package com.larina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.larina.jdbc.DataSourceConfig;
import com.larina.jdbc.JDBCController;
import com.larina.model.Stand;

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
