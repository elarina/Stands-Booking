package com.larina.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.larina.model.Employee;
import com.larina.model.Role;
import com.larina.model.Stand;
import com.larina.model.Status;
import com.larina.repositories.EmployeeRepository;
import com.larina.repositories.RolesRepository;
import com.larina.repositories.StandsRepository;
import com.larina.repositories.StatusesRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private StandsRepository standsRepository;

	@Autowired
	private StatusesRepository statusesRepository;

	@Autowired
	private RolesRepository rolesRepository;

	
	
	@Override
	public void run(String... args) throws Exception {
			Employee e1 = new Employee("petrpetrov", "Petr", "Petrov");
			Employee e2 = new Employee("ivanivanov", "Ivan", "Ivanov");
			Employee e3 = new Employee("sidorsidorov", "Sidor", "Sidorov");
			Employee e4 = new Employee("sidorsidorov2", "Sidor", "Sidorov2");
			Employee e5 = new Employee("ivanivanov2", "Ivan", "Ivanov2");
			employeeRepository.saveAll(List.of(e1, e2, e3, e4, e5));
			
			Stand s1 = new Stand("ggg", "111.111.111.111", "uio", "1234");
			Stand s2 = new Stand("ggg1", "111.111.111.112", "uio", "1234");
			Stand s3 = new Stand("ggg2", "111.111.111.113", "uio", "1234");
			standsRepository.saveAll(List.of(s1, s2, s3));
			
			Role role1 = new Role("user");
			Role role2 = new Role("admin");
			rolesRepository.saveAll(List.of(role1, role2));
			
			Status status1 = new Status(e1.getId(), s1.getId(), true);
			statusesRepository.save(status1);
	}

}
