package com.cootoo.metamanagement.domain;

public class Card {

	private String cardMacID;
	private Integer cardName;
	private String cardIsLive;
	private String cardRegisterTime;
	private Integer cardTypeID;
	private String orgID;
		
	public Card() {
		super();
	}

	
	
	public Card(String cardMacID, Integer cardName, String cardIsLive,
			String cardRegisterTime, Integer cardTypeID, String orgID) {
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

	public Integer getCardName() {
		return cardName;
	}

	public void setCardName(Integer cardName) {
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

	public Integer getCardTypeID() {
		return cardTypeID;
	}

	public void setCardTypeID(Integer cardTypeID) {
		this.cardTypeID = cardTypeID;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}
	
	
	
	
	
}
