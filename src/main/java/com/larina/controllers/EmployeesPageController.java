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
import com.advalange.model.Employee;

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
	public String removeStand(@RequestParam(value = "employee_ids", required = false) int[] ids, Model model) {
		System.out.println("delete");
		if (ids == null) {
			return "redirect:/employees";
		}
		for (int id : ids) {
			controller.removeEmployee(id);

		}
		return "redirect:/employees";
	}

	@PostMapping(value = "/employees", params = "cancel")
	public String cancelRemove(Model model) {
		System.out.println("cancel");
		return "redirect:/employees";
	}
}
