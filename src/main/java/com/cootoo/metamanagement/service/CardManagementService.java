package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cootoo.metamanagement.domain.Card;

public interface CardManagementService {

	Map<String,Object> addCard(List<Card> cardList);
	
	Map<String,Object> addCard(MultipartFile file);
	
	Map<String,Object> deleteCard(List<String> cardIDList);
	
	Map<String,Object> modifyCard(Card card);
	
	Map<String,Object> getCardType();
}
