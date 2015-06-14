package com.cootoo.systemmanagement.domain;

public class Login {

	private Integer loginID;
	private String loginAccount;
	private String loginPassword;
	private Integer orgID;
	private Integer roleID;
		
	public Login() {
		super();
	}
	
	public Login(String loginAccount, String loginPassword,
			Integer orgID, Integer roleID) {
		super();
		this.loginAccount = loginAccount;
		this.loginPassword = loginPassword;
		this.orgID = orgID;
		this.roleID = roleID;
	}


	public Integer getLoginID() {
		return loginID;
	}
	public void setLoginID(Integer loginID) {
		this.loginID = loginID;
	}
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public Integer getOrgID() {
		return orgID;
	}
	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	
	
}
