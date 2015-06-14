package com.cootoo.metamanagement.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cootoo.metamanagement.service.CardManagementService;

@Controller
public class CardManagementAction{

	@Autowired
	private CardManagementService cardManagementServiceImpl;
	
}
