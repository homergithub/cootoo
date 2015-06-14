package com.cootoo.menuManagement.domain;

import java.util.List;

public class Menu {

	private String role;
	private List<Module> modules;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	
}
