package com.cootoo.metamanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.PeopleManagementDao;
import com.cootoo.metamanagement.service.PeopleManagementService;

@Service
public class PeopleManagementServiceImpl implements PeopleManagementService {

	@Autowired
	private PeopleManagementDao peopleManagementDaoImpl;
}
