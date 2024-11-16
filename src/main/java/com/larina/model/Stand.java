package com.larina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stands")
public class Stand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String ip;
	private String username;
	private String password;
	
	public Stand() {
		
	}
	
	public Stand(String name, String ip, String username, String password) {
		super();
		this.name = name;
		this.ip = ip;
		this.username = username;
		this.password = password;
	}
	
	public Stand(int id, String name, String ip, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.ip = ip;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}


	public String getIp() {
		return ip;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
