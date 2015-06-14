package com.cootoo.dormManagement.domain;

public class UserToLocation {

	private String peopleID;
	private String locationID;
	private String userLocationLinkType;
	
	
	public UserToLocation() {
		super();
	}
	
	public UserToLocation(String peopleID, String locationID,
			String userLocationLinkType) {
		super();
		this.peopleID = peopleID;
		this.locationID = locationID;
		this.userLocationLinkType = userLocationLinkType;
	}

	public String getPeopleID() {
		return peopleID;
	}
	public void setPeopleID(String peopleID) {
		this.peopleID = peopleID;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public String getUserLocationLinkType() {
		return userLocationLinkType;
	}
	public void setUserLocationLinkType(String userLocationLinkType) {
		this.userLocationLinkType = userLocationLinkType;
	}
	
	
}
