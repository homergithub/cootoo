package com.cootoo.metamanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.CardManagementDao;
import com.cootoo.metamanagement.service.CardManagementService;

@Service
public class CardManagementServiceImpl implements CardManagementService {

	@Autowired
	private CardManagementDao cardManagementDaoImpl;
	
}
