package com.advalange.jdbc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.advalange.model.Employee;
import com.advalange.model.Stand;


public class JDBCController {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCController(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	public List<Employee> queryTowns() {
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "SELECT name, lastname FROM employee";
		
		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> record: records) {
			String name = (String)record.get("name");
			String lastname = (String)record.get("lastname");
			employees.add(new Employee(name, lastname));
		}
		
		return employees;
	}
	
	public List<Stand> queryStands() {
		List<Stand> stands = new ArrayList<Stand>();
		
		String sql = "SELECT id, name, ip, username, password, busy FROM stands";
				
		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> record: records) {
			int id = (int)record.get("id");
			String name = (String)record.get("name");
			String ip = (String)record.get("ip");
			String username = (String)record.get("username");
			String password = (String) record.get("password");
		    boolean busy = (boolean) record.get("busy");
			stands.add(new Stand(id, name, ip, username, password, busy));
		}
	
		return stands;
	}
}