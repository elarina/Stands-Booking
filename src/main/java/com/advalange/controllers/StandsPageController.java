package com.advalange.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.advalange.jdbc.DataSourceConfig;
import com.advalange.jdbc.JDBCController;
import com.advalange.model.Stand;

@Controller
public class StandsPageController {

	private JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());

	@GetMapping("/stands")
	public String showStandsPage(Model model) {
		addStands(model);
		return "stands";
	}

	private void addStands(Model model) {
		List<Stand> stands = controller.queryStands();
		List<Integer> standIds = new ArrayList<>();
		model.addAttribute("stands", stands);
		model.addAttribute("stand_ids", standIds);
//		model.addAttribute("name", stands.stream().map(s -> s.getName()).toList());
//		model.addAttribute("ip", stands.stream().map(Stand::getIp).toList());
	}

	@PostMapping(value = "/stands", params = "addStand")
	public void addStand(Model model) {

	}

	@PostMapping(value = "/stands", params = "removeStand")
	public String removeStand(@RequestParam(value = "stand_ids", required = false) int[] cers, Model model) {
		if(cers == null) {
			return "redirect:/stands";
		}		
		for (int i : cers) {
			System.out.println(i);
		}
		
		controller.removeStands(cers);
		
		return "redirect:/stands";
	}

}