package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.Card;
import com.cootoo.metamanagement.domain.CardType;

public interface CardManagementDao {

	int insertCard(List<Card> cardList);
	
	int deleteCard(List<String> cardIDList);
	
	int updateCard(Card card);
	
	List<CardType> selectCardType();
}
