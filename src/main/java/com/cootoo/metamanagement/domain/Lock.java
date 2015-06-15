package com.cootoo.metamanagement.domain;


public class Lock {

	private String lockMacID;
	private String lockName;
	private String locationID;
	private String isLive;
	private String repeaterID;
	private String updateTime;
	private String activeTime;
	private Integer battery;
	private String signal;
	
	public Lock() {
		super();
	}
	
	
	
	public Lock(String lockMacID, String lockName, String locationID,
			String isLive, String repeaterID, String updateTime,
			String activeTime, Integer battery, String signal) {
		super();
		this.lockMacID = lockMacID;
		this.lockName = lockName;
		this.locationID = locationID;
		this.isLive = isLive;
		this.repeaterID = repeaterID;
		this.updateTime = updateTime;
		this.activeTime = activeTime;
		this.battery = battery;
		this.signal = signal;
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
	public String getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	public Integer getBattery() {
		return battery;
	}
	public void setBattery(Integer battery) {
		this.battery = battery;
	}
	public String getSignal() {
		return signal;
	}
	public void setSignal(String signal) {
		this.signal = signal;
	}


	
	
	
	

}
