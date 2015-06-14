package com.cootoo.metamanagement.domain;


public class Lock {

	private String lockMacID;
	private String lockName;
	private String locationID;
	private String isLive;
	private String repeaterID;
	private String updateTime;
	private String unitName;
	private String repeaterName;
	
	public Lock() {
		super();
	}
	
	public Lock(String lockMacID, String lockName, String locationID,
			String isLive, String repeaterID, String updateTime) {
		super();
		this.lockMacID = lockMacID;
		this.lockName = lockName;
		this.locationID = locationID;
		this.isLive = isLive;
		this.repeaterID = repeaterID;
		this.updateTime = updateTime;
	}

	public String getLockMacID() {
		return lockMacID;
	}
	public void setLockMacID(String lockMacID) {
		this.lockMacID = lockMacID;
	}
	public String getLockName() {
		return lockName;
	}
	public void setLockName(String lockName) {
		this.lockName = lockName;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public String getIsLive() {
		return isLive;
	}
	public void setIsLive(String isLive) {
		this.isLive = isLive;
	}
	public String getRepeaterID() {
		return repeaterID;
	}
	public void setRepeaterID(String repeaterID) {
		this.repeaterID = repeaterID;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getRepeaterName() {
		return repeaterName;
	}

	public void setRepeaterName(String repeaterName) {
		this.repeaterName = repeaterName;
	}

	
	
	
	

}
