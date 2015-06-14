package com.cootoo.metamanagement.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cootoo.metamanagement.service.LockManagementService;

@Controller
public class LockManagementAction{

	@Autowired
	private LockManagementService lockManagementServiceImpl;
}
