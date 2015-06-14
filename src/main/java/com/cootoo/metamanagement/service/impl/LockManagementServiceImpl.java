package com.cootoo.metamanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.LockManagementDao;
import com.cootoo.metamanagement.service.LockManagementService;

@Service
public class LockManagementServiceImpl implements LockManagementService {

	@Autowired
	private LockManagementDao lockManagementDaoImpl;
}
