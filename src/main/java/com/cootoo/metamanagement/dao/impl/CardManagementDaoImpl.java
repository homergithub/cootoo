package com.cootoo.metamanagement.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.CardManagementDao;

@Repository
public class CardManagementDaoImpl implements CardManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	
	
	
}
