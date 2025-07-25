package com.larina.ui;

public class BookingStandButton {
	private String standName;
	private long standId;
	private String actionUrl;

	public BookingStandButton(String standName, long standId, String actionUrl) {
		this.standName = standName;
		this.standId = standId;
		this.actionUrl = actionUrl;
	}

	public String getStandName() {
		return standName;
	}

	public void setStandName(String standName) {
		this.standName = standName;
	}

	public long getStandId() {
		return standId;
	}

	public void setStandId(long standId) {
		this.standId = standId;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	
}
