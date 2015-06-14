package com.cootoo.metamanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.RepeaterManagementDao;
import com.cootoo.metamanagement.service.RepeaterManagementService;

@Service
public class RepeaterManagementServiceImpl implements RepeaterManagementService {

	@Autowired
	private RepeaterManagementDao repeaterManagementDaoImpl;
}
