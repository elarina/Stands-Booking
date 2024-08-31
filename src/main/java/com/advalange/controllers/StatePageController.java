package com.advalange.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.advalange.jdbc.DataSourceConfig;
import com.advalange.jdbc.JDBCController;
import com.advalange.model.Stand;

@Controller
public class StatePageController {
	
	private JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());	
	
	@GetMapping("/stands")
	public String showStandsPage(Model model) {
		addStands(model);
		return "stands";
	}

	private void addStands(Model model) {
		List<Stand> stands = controller.queryStands();
		model.addAttribute("stands", stands);
//		model.addAttribute("name", stands.stream().map(s -> s.getName()).toList());
//		model.addAttribute("ip", stands.stream().map(Stand::getIp).toList());
	}
}