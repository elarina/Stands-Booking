package com.larina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="stand_groups_relations")
public class StandsGroupRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name="parent_group_id")
	private Long parentGroupId;
	
	@JoinColumn(name="child_group_id")
	private Long childGroupId;

	public StandsGroupRelation(Long parentGroupId, Long childGroupId) {
		this.parentGroupId = parentGroupId;
		this.childGroupId = childGroupId;
	}

	public Long getParentGroupId() {
		return parentGroupId;
	}

	public void setParentGroupId(Long parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

	public Long getChildGroupId() {
		return childGroupId;
	}

	public void setChildGroupId(Long childGroupId) {
		this.childGroupId = childGroupId;
	}
}
