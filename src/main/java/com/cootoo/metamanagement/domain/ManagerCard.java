package com.cootoo.metamanagement.domain;

public class ManagerCard {

	private String managerCardID;
	private String managerCardName;
	private String managerType;
	private String orgID;
	

	public ManagerCard() {
		super();
	}
		
	public ManagerCard(String managerCardID, String managerCardName,
			String managerType, String orgID) {
		super();
		this.managerCardID = managerCardID;
		this.managerCardName = managerCardName;
		this.managerType = managerType;
		this.orgID = orgID;
	}

	public String getManagerCardID() {
		return managerCardID;
	}
	public void setManagerCardID(String managerCardID) {
		this.managerCardID = managerCardID;
	}
	public String getManagerCardName() {
		return managerCardName;
	}
	public void setManagerCardName(String managerCardName) {
		this.managerCardName = managerCardName;
	}
	public String getManagerType() {
		return managerType;
	}
	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}
	public String getOrgID() {
		return orgID;
	}
	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}	
	
}
