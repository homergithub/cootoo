package com.cootoo.systemmanagement.domain;

import java.util.List;

public class LoginRole {

	private Integer loginID;
	private String orgID;
	private String loginAccount;
	private Integer roleID;
	private String roleName;
	private String orgName;
	
	private List<Module> modules;

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Integer getLoginID() {
		return loginID;
	}

	public void setLoginID(Integer loginID) {
		this.loginID = loginID;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}
	
	
	
}
