package com.cootoo.metamanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.CardManagementDao;
import com.cootoo.metamanagement.domain.Card;
import com.cootoo.metamanagement.service.CardManagementService;

@Service
public class CardManagementServiceImpl implements CardManagementService {

	@Autowired
	private CardManagementDao cardManagementDaoImpl;
	
	private final String INSERT_SUCCESS="添加门卡成功!";
	
	private final String MODIFY_SUCCESS="修改门卡成功!";

	@Override
	public Map<String, Object> addCard(List<Card> cardList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		cardManagementDaoImpl.insertCard(cardList);
		result.put("msg", INSERT_SUCCESS);
		return result; 
	}

	@Override
	public Map<String, Object> deleteCard(List<String> cardIDList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		int rows = cardManagementDaoImpl.deleteCard(cardIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}

	@Override
	public Map<String, Object> modifyCard(Card card) {
		Map<String,Object> result = new HashMap<String, Object>();		
		cardManagementDaoImpl.updateCard(card);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}
	
	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条门卡信息";
	}
	
}
