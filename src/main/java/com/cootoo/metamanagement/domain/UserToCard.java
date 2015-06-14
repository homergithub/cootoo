package com.cootoo.metamanagement.domain;

public class UserToCard {

	private String peopleID;
	private String cardMacID;
	
	public UserToCard() {
		super();
	}
	
	public UserToCard(String peopleID, String cardMacID) {
		super();
		this.peopleID = peopleID;
		this.cardMacID = cardMacID;
	}


	public String getPeopleID() {
		return peopleID;
	}
	public void setPeopleID(String peopleID) {
		this.peopleID = peopleID;
	}
	public String getCardMacID() {
		return cardMacID;
	}
	public void setCardMacID(String cardMacID) {
		this.cardMacID = cardMacID;
	}
	
}
