package com.cootoo.metamanagement.domain;

public class FrontMachine {

	private String machineName;
	private String machineIP;
	private String machinePort;
	private String locationID;
	private String isLive;
	private String activeTime;
	private String machineMark;
	
	
	public FrontMachine() {
		super();
	}
	

	public FrontMachine(String machineName, String machineIP,
			String machinePort, String locationID, String isLive,
			String activeTime, String machineMark) {
		super();
		this.machineName = machineName;
		this.machineIP = machineIP;
		this.machinePort = machinePort;
		this.locationID = locationID;
		this.isLive = isLive;
		this.activeTime = activeTime;
		this.machineMark = machineMark;
	}


	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getMachineIP() {
		return machineIP;
	}
	public void setMachineIP(String machineIP) {
		this.machineIP = machineIP;
	}
	public String getMachinePort() {
		return machinePort;
	}
	public void setMachinePort(String machinePort) {
		this.machinePort = machinePort;
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
	public String getMachineMark() {
		return machineMark;
	}
	public void setMachineMark(String machineMark) {
		this.machineMark = machineMark;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	
	
}
