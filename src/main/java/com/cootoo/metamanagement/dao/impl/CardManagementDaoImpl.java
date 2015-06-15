package com.cootoo.metamanagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.CardManagementDao;
import com.cootoo.metamanagement.domain.Card;

@Repository
public class CardManagementDaoImpl implements CardManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertCard(List<Card> cardList) {
		return sqlSessionTemplate.insert("cardModule.insertCard", cardList);
	}

	@Override
	public int deleteCard(List<String> cardIDList) {
		return sqlSessionTemplate.delete("cardModule.deleteCard", cardIDList);
	}

	@Override
	public int updateCard(Card card) {
		return sqlSessionTemplate.update("cardModule.updateCard", card);
	}
	
	
	
	
	
}
