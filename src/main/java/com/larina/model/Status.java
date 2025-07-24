package com.larina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="statuses")
public 	class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long stand_id;
	
	private Long employee_id;
	
	// if true - then busy
	private boolean status;

	public Status() {}
	
	public Status(Long stand_id, Long employee_id, boolean status) {
		super();
		this.stand_id = stand_id;
		this.employee_id = employee_id;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStand_id() {
		return stand_id;
	}

	public void setStand_id(Long stand_id) {
		this.stand_id = stand_id;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
