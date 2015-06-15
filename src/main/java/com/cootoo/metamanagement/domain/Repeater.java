package com.cootoo.metamanagement.domain;

public class Repeater {

	private String repeaterID;
	private String repeaterName;
	private String repeaterIP;
	private String locationID;
	private String updateTime;
	private String activeTime;
	private String status;
	
	public Repeater() {
		super();
	}
	
	
	
	public Repeater(String repeaterID, String repeaterName, String repeaterIP,
			String locationID, String updateTime, String activeTime,
			String status) {
		super();
		this.repeaterID = repeaterID;
		this.repeaterName = repeaterName;
		this.repeaterIP = repeaterIP;
		this.locationID = locationID;
		this.updateTime = updateTime;
		this.activeTime = activeTime;
		this.status = status;
	}



	public String getRepeaterID() {
		return repeaterID;
	}
	public void setRepeaterID(String repeaterID) {
		this.repeaterID = repeaterID;
	}
	public String getRepeaterName() {
		return repeaterName;
	}
	public void setRepeaterName(String repeaterName) {
		this.repeaterName = repeaterName;
	}
	public String getRepeaterIP() {
		return repeaterIP;
	}
	public void setRepeaterIP(String repeaterIP) {
		this.repeaterIP = repeaterIP;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
