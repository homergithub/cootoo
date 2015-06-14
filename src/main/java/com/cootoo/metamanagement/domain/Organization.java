package com.cootoo.metamanagement.domain;

public class Organization {

	private String orgID;
	private String orgName;
	
	public Organization() {
		super();
	}
	
	public Organization(String orgID, String orgName) {
		super();
		this.orgID = orgID;
		this.orgName = orgName;
	}

	public String getOrgID() {
		return orgID;
	}
	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
}
