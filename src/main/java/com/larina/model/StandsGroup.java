package com.larina.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "stand_groups")
public class StandsGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;	
	
	@OneToMany(targetEntity = Stand.class, mappedBy = "group")
	private List<Stand> stands = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public Long setId(Long id) {
		return this.id = id;
	}
	
	public StandsGroup() {}
	
	public StandsGroup(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Stand> getStands() {
		return stands;
	}

	public void setStands(List<Stand> stands) {
		this.stands = stands;
	}

	public void addStand(Stand stand) {
		this.stands.add(stand);
	}
	
	public void removeStand(Stand stand) {
		if(this.stands.contains(stand)) {
			this.stands.remove(stand);
		}
	}
}
