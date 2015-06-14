package com.cootoo.metamanagement.domain;

public class UnitLocation {

	private String locationID;
	private String unitName;
	private String parentNode;
	private String treePath;
	private String unitType;
	private Integer unitSize;
	private String sex;
	private String orgID;
	
	
	public UnitLocation() {
		super();
	}


	public UnitLocation(String locationID, String unitName, String parentNode,
			String treePath, String unitType, String orgID, Integer unitSize,
			String sex) {
		super();
		this.locationID = locationID;
		this.unitName = unitName;
		this.parentNode = parentNode;
		this.treePath = treePath;
		this.unitType = unitType;
		this.orgID = orgID;
		this.unitSize = unitSize;
		this.sex = sex;
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


	public String getParentNode() {
		return parentNode;
	}


	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}


	public String getTreePath() {
		return treePath;
	}


	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}


	public String getUnitType() {
		return unitType;
	}


	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}


	public String getOrgID() {
		return orgID;
	}


	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}


	public Integer getUnitSize() {
		return unitSize;
	}


	public void setUnitSize(Integer unitSize) {
		this.unitSize = unitSize;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	
}
