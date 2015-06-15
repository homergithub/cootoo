package com.cootoo.metamanagement.domain;

public class People {
	
	private String peopleID;
	private String peopleName;
	private String sex;
	private String peopleTel;
	private Integer peopleTypeID;
	private Integer peopleSignID;
	private String departmentID;
	private String mark;
	private String isAllocated;
	private String isInSchool;
	
	public People() {
		super();
	}
		
	public People(String peopleID, String peopleName, String sex,
			String peopleTel, Integer peopleTypeID, Integer peopleSignID,
			String departmentID, String mark, String isAllocated,
			String isInSchool) {
		super();
		this.peopleID = peopleID;
		this.peopleName = peopleName;
		this.sex = sex;
		this.peopleTel = peopleTel;
		this.peopleTypeID = peopleTypeID;
		this.peopleSignID = peopleSignID;
		this.departmentID = departmentID;
		this.mark = mark;
		this.isAllocated = isAllocated;
		this.isInSchool = isInSchool;
	}






	public String getPeopleID() {
		return peopleID;
	}
	public void setPeopleID(String peopleID) {
		this.peopleID = peopleID;
	}
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPeopleTel() {
		return peopleTel;
	}
	public void setPeopleTel(String peopleTel) {
		this.peopleTel = peopleTel;
	}
	
	

	




	public Integer getUserTypeID() {
		return peopleTypeID;
	}





	public void setUserTypeID(Integer peopleTypeID) {
		this.peopleTypeID = peopleTypeID;
	}





	public Integer getPeopleSignID() {
		return peopleSignID;
	}





	public void setPeopleSignID(Integer peopleSignID) {
		this.peopleSignID = peopleSignID;
	}





	public String getDepartmentID() {
		return departmentID;
	}




	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}




	


	public String getMark() {
		return mark;
	}






	public void setMark(String mark) {
		this.mark = mark;
	}






	public String getIsAllocated() {
		return isAllocated;
	}

	public void setIsAllocated(String isAllocated) {
		this.isAllocated = isAllocated;
	}

	
	
	
	public Integer getPeopleTypeID() {
		return peopleTypeID;
	}





	public void setPeopleTypeID(Integer peopleTypeID) {
		this.peopleTypeID = peopleTypeID;
	}





	public String getIsInSchool() {
		return isInSchool;
	}





	public void setIsInSchool(String isInSchool) {
		this.isInSchool = isInSchool;
	}



	
}
