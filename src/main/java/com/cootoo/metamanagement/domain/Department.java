package com.cootoo.metamanagement.domain;

public class Department {

	private String departmentID;
	private String departmentName;
	private String departmentPID;
	private Integer departmentType;
	private String departmentPosition;
	private String departmentDescription;
	private String orgID;
	
	public Department() {
		super();
	}
	
	public Department(String departmentID, String departmentName,
			String departmentPID, Integer departmentType,
			String departmentPosition, String departmentDescription,
			String orgID) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.departmentPID = departmentPID;
		this.departmentType = departmentType;
		this.departmentPosition = departmentPosition;
		this.departmentDescription = departmentDescription;
		this.orgID = orgID;
	}
	
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentPID() {
		return departmentPID;
	}
	public void setDepartmentPID(String departmentPID) {
		this.departmentPID = departmentPID;
	}
	public Integer getDepartmentType() {
		return departmentType;
	}
	public void setDepartmentType(Integer departmentType) {
		this.departmentType = departmentType;
	}
	public String getDepartmentPosition() {
		return departmentPosition;
	}
	public void setDepartmentPosition(String departmentPosition) {
		this.departmentPosition = departmentPosition;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getOrgID() {
		return orgID;
	}
	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}
	
	
	
	
}
