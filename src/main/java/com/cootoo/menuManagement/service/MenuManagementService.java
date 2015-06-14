package com.cootoo.menuManagement.service;


import java.util.Map;

import com.cootoo.menuManagement.domain.Menu;


public interface MenuManagementService {

	Map<String,Object> getModules(); 
	Map<String,Object> getFunctions(int moduleID);
	Map<String,Object> getMenus();
	Menu getRoleFunctions(int userID);
}
