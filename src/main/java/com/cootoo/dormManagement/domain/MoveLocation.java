package com.cootoo.dormManagement.domain;

public class MoveLocation {

	private int moveLocationID;
	private String moveDescription;
	private String peopleID;
	private String fromLocationID;
	private String toLocationID;
	private String moveLocationTime;
	private int moveLocationType;
	
	public MoveLocation() {
		super();
	}
	
	
	public MoveLocation(String moveDescription, String peopleID,
			String toLocationID, String moveLocationTime, int moveLocationType) {
		super();
		this.moveDescription = moveDescription;
		this.peopleID = peopleID;
		this.toLocationID = toLocationID;
		this.moveLocationTime = moveLocationTime;
		this.moveLocationType = moveLocationType;
	}

	

	public MoveLocation(String moveDescription, String peopleID,
			String fromLocationID, String toLocationID,
			String moveLocationTime, int moveLocationType) {
		super();
		this.moveDescription = moveDescription;
		this.peopleID = peopleID;
		this.fromLocationID = fromLocationID;
		this.toLocationID = toLocationID;
		this.moveLocationTime = moveLocationTime;
		this.moveLocationType = moveLocationType;
	}


	public int getMoveLocationID() {
		return moveLocationID;
	}
	public void setMoveLocationID(int moveLocationID) {
		this.moveLocationID = moveLocationID;
	}
	
	public String getMoveDescription() {
		return moveDescription;
	}


	public void setMoveDescription(String moveDescription) {
		this.moveDescription = moveDescription;
	}


	public String getPeopleID() {
		return peopleID;
	}
	public void setPeopleID(String peopleID) {
		this.peopleID = peopleID;
	}
	public String getFromLocationID() {
		return fromLocationID;
	}
	public void setFromLocationID(String fromLocationID) {
		this.fromLocationID = fromLocationID;
	}
	public String getToLocationID() {
		return toLocationID;
	}
	public void setToLocationID(String toLocationID) {
		this.toLocationID = toLocationID;
	}
	public String getMoveLocationTime() {
		return moveLocationTime;
	}
	public void setMoveLocationTime(String moveLocationTime) {
		this.moveLocationTime = moveLocationTime;
	}
	public int getMoveLocationType() {
		return moveLocationType;
	}
	public void setMoveLocationType(int moveLocationType) {
		this.moveLocationType = moveLocationType;
	}
	
	
}
