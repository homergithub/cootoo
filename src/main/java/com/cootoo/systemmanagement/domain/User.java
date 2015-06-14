package com.cootoo.systemmanagement.domain;

public class User {

	private Integer userID;
	private String userAccount;
	private String userPassword;
	private Integer orgID;
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getOrgID() {
		return orgID;
	}
	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}
	
	
}
