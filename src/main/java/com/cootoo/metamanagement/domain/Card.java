package com.cootoo.metamanagement.domain;

public class Card {

	private String cardMacID;
	private int cardName;
	private String cardIsLive;
	private String cardRegisterTime;
	private int cardTypeID;
	private int orgID;
		
	public Card() {
		super();
	}
	
	
	
	public Card(String cardMacID, int cardName, String cardIsLive,
			int cardTypeID) {
		super();
		this.cardMacID = cardMacID;
		this.cardName = cardName;
		this.cardIsLive = cardIsLive;
		this.cardTypeID = cardTypeID;
	}



	public Card(String cardMacID, int cardName, String cardIsLive,
			String cardRegisterTime, int cardTypeID) {
		super();
		this.cardMacID = cardMacID;
		this.cardName = cardName;
		this.cardIsLive = cardIsLive;
		this.cardRegisterTime = cardRegisterTime;
		this.cardTypeID = cardTypeID;
	}

	

	


	public Card(String cardMacID, int cardName, String cardIsLive,
			String cardRegisterTime, int cardTypeID, int orgID) {
		super();
		this.cardMacID = cardMacID;
		this.cardName = cardName;
		this.cardIsLive = cardIsLive;
		this.cardRegisterTime = cardRegisterTime;
		this.cardTypeID = cardTypeID;
		this.orgID = orgID;
	}



	public String getCardMacID() {
		return cardMacID;
	}
	public void setCardMacID(String cardMacID) {
		this.cardMacID = cardMacID;
	}
	public int getCardName() {
		return cardName;
	}
	public void setCardName(int cardName) {
		this.cardName = cardName;
	}
	public String getCardIsLive() {
		return cardIsLive;
	}
	public void setCardIsLive(String cardIsLive) {
		this.cardIsLive = cardIsLive;
	}
	public String getCardRegisterTime() {
		return cardRegisterTime;
	}
	public void setCardRegisterTime(String cardRegisterTime) {
		this.cardRegisterTime = cardRegisterTime;
	}
	public int getCardTypeID() {
		return cardTypeID;
	}
	public void setCardTypeID(int cardTypeID) {
		this.cardTypeID = cardTypeID;
	}

	public int getOrgID() {
		return orgID;
	}
	
	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}
	
	
	
}
