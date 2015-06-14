package com.cootoo.metamanagement.domain;

public class Repeater {

	private String repeaterID;
	private String repeaterName;
	private String repeaterIP;
	private String locationID;
	private String unitName;

	public Repeater() {
		super();
	}
	
	public Repeater(String repeaterID, String repeaterName,
			String repeaterIP,String locationID) {
		super();
		this.repeaterID = repeaterID;
		this.repeaterName = repeaterName;
		this.repeaterIP = repeaterIP;
		this.locationID = locationID;
	}

	
	public Repeater(String repeaterID, String repeaterName, String repeaterIP) {
		super();
		this.repeaterID = repeaterID;
		this.repeaterName = repeaterName;
		this.repeaterIP = repeaterIP;
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	
}
