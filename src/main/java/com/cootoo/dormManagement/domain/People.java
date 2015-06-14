package com.cootoo.dormManagement.domain;

import java.io.Serializable;

public class People implements Serializable{

	private static final long serialVersionUID = 3848285466290904247L;
	
	private String id;
	private String pId;
	private String name;
	private int peopleTypeID;
	private int peopleSignID;
	private String peopleTel;
	private String userMark;
	private String sex;
	private String type;
	private String locationID;
	private String isAllocated;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public int getUserTypeID() {
		return peopleTypeID;
	}
	public void setUserTypeID(int peopleTypeID) {
		this.peopleTypeID = peopleTypeID;
	}
	public int getPeopleSignID() {
		return peopleSignID;
	}
	public void setPeopleSignID(int peopleSignID) {
		this.peopleSignID = peopleSignID;
	}
	public String getPeopleTel() {
		return peopleTel;
	}
	public void setPeopleTel(String peopleTel) {
		this.peopleTel = peopleTel;
	}

	public String getUserMark() {
		return userMark;
	}
	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsAllocated() {
		return isAllocated;
	}
	public void setIsAllocated(String isAllocated) {
		this.isAllocated = isAllocated;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	
	
}
