package com.larina.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.larina.model.Employee;
import com.larina.repositories.EmployeeRepository;

@Controller
public class EmployeesPageController {
	private final EmployeeRepository employeeRepository;

	public EmployeesPageController(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/employees")
	public String showEmployeesPage(Model model) {
		addEmployees(model);
		return "employees";
	}

	private void addEmployees(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		List<Integer> employeeIds = new ArrayList<>();
		model.addAttribute("employees", employees);
		model.addAttribute("employee_ids", employeeIds);		
	}
	

	@PostMapping(value = "/employees", params = "delete")
	public String removeStand(@RequestParam(value = "employee_ids", required = false) long[] ids, Model model) {
		System.out.println("delete");
		if (ids == null) {
			return "redirect:/employees";
		}
		for (long id: ids) {
			Optional<Employee> employee = employeeRepository.findById(id);
			if(employee.isPresent()) {
				employeeRepository.delete(employee.get());
			}
		}
		return "redirect:/employees";
	}

	@PostMapping(value = "/employees", params = "cancel")
	public String cancelRemove(Model model) {
		System.out.println("cancel");
		return "redirect:/employees";
	}
}
