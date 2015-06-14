package com.cootoo.menuManagement.dao;

import java.util.List;

import com.cootoo.menuManagement.domain.Function;
import com.cootoo.menuManagement.domain.Menu;
import com.cootoo.menuManagement.domain.Module;

public interface MenuManagementDao {

	List<Module> getModules(); 
	
	List<Function> getFunctions(int moduleID);
	
	List<Module> getMenus();
	
	
	Menu selectRoleFunctions(int userID);
	
	
}
