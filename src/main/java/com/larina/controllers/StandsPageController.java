package com.larina.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.larina.jdbc.DataSourceConfig;
import com.larina.jdbc.JDBCController;
import com.larina.model.Stand;

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

	@PostMapping(value = "/stands", params = "delete")
	public String removeStand(@RequestParam(value = "stand_ids", required = false) int[] ids, Model model) {
		System.out.println("delete");
		if (ids == null) {
			return "redirect:/stands";
		}
		for (int id : ids) {
			controller.removeStand(id);

		}
		return "redirect:/stands";
	}

	@PostMapping(value = "/stands", params = "cancel")
	public String cancelRemove(Model model) {
		System.out.println("cancel");
		return "redirect:/stands";
	}

}