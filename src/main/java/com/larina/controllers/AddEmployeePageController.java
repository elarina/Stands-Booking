package com.larina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.larina.model.Employee;
import com.larina.model.Stand;
import com.larina.repositories.EmployeeRepository;

@Controller
public class AddEmployeePageController {

	private final EmployeeRepository employeeRepository;
	
	public AddEmployeePageController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/addEmployee") 
	public String showAddEmployeePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@PostMapping(value = "/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		employeeRepository.save(employee);
		return "redirect:/employees";
	}
	
	@PostMapping(value = "/addEmployee", params = "cancel")
	public String cancelAddEmployee(@ModelAttribute Stand stand, Model model) {
		return "redirect:/employees";
	}
}
