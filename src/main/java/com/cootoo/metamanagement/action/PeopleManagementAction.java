package com.cootoo.metamanagement.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cootoo.metamanagement.service.PeopleManagementService;

@Controller
public class PeopleManagementAction{

	@Autowired
	private PeopleManagementService peopleManagementServiceImpl;
}
