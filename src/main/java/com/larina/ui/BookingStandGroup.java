package com.larina.ui;

public class BookingStandGroup {

	private final String groupName;
	private final Long groupId;
	private final String actionUrl;
	
	public BookingStandGroup(String groupName, Long groupId, String actionUrl) {
		this.groupName = groupName;
		this.groupId = groupId;
		this.actionUrl = actionUrl;
	}

	public String getGroupName() {
		return groupName;
	}

	public Long getGroupId() {
		return groupId;
	}

	public String getActionUrl() {
		return actionUrl;
	}
	
}
