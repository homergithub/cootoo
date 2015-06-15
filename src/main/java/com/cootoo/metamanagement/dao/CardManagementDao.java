package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.Card;

public interface CardManagementDao {

	int insertCard(List<Card> cardList);
	
	int deleteCard(List<String> cardIDList);
	
	int updateCard(Card card);
}
