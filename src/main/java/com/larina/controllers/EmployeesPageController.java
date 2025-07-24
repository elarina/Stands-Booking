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
import com.larina.model.Employee;

@Controller
public class EmployeesPageController {
	private JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());
	
	@GetMapping("/employees")
	public String showEmployeesPage(Model model) {
		addEmployees(model);
		return "employees";
	}

	private void addEmployees(Model model) {
		List<Employee> employees = controller.queryEmployees();
		List<Integer> employeeIds = new ArrayList<>();
		model.addAttribute("employees", employees);
		model.addAttribute("employee_ids", employeeIds);		
	}
	

	@PostMapping(value = "/employees", params = "delete")
	public String removeStand(@RequestParam(value = "employee_ids", required = false) String[] usernames, Model model) {
		System.out.println("delete");
		if (usernames == null) {
			return "redirect:/employees";
		}
		for (String username: usernames) {
			controller.removeEmployee(username);

		}
		return "redirect:/employees";
	}

	@PostMapping(value = "/employees", params = "cancel")
	public String cancelRemove(Model model) {
		System.out.println("cancel");
		return "redirect:/employees";
	}
}
