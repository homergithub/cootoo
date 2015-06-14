package com.cootoo.metamanagement.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cootoo.metamanagement.service.RepeaterManagementService;

@Controller
public class RepeaterManagementAction{

	@Autowired
	private RepeaterManagementService repeaterManagementServiceImpl;
}
