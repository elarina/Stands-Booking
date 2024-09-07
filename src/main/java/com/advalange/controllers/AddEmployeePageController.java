package com.advalange.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.advalange.jdbc.DataSourceConfig;
import com.advalange.jdbc.JDBCController;
import com.advalange.model.Employee;
import com.advalange.model.Stand;
@Controller
public class AddEmployeePageController {
	private JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());
	
	@GetMapping("/addEmployee") 
	public String showAddEmployeePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@PostMapping(value = "/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		controller.addEmployee(employee);	
		return "redirect:/employees";
	}
	
	@PostMapping(value = "/addEmployee", params = "cancel")
	public String cancelAddEmployee(@ModelAttribute Stand stand, Model model) {
		return "redirect:/addStand";
	}
}
