package com.cootoo.menuManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.menuManagement.dao.MenuManagementDao;
import com.cootoo.menuManagement.domain.Function;
import com.cootoo.menuManagement.domain.Menu;
import com.cootoo.menuManagement.domain.Module;
import com.cootoo.menuManagement.service.MenuManagementService;
@Service
public class MenuManagementServiceImpl implements MenuManagementService {

	@Autowired
	private MenuManagementDao menuManagementDaoImpl;
	
	@Override
	public Map<String,Object> getModules() {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Module> modules = menuManagementDaoImpl.getModules();
		result.put("data", modules);
		return result;
	}

	@Override
	public Map<String, Object> getFunctions(int moduleID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Function> functions = menuManagementDaoImpl.getFunctions(moduleID);
		result.put("data", functions);
		return result;
	}

	@Override
	public Map<String, Object> getMenus() {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Module> menus = menuManagementDaoImpl.getMenus();
		result.put("data", menus);
		return result;
	}

	@Override
	public Menu getRoleFunctions(int userID) {
		Menu roleFucntion = menuManagementDaoImpl.selectRoleFunctions(userID);
		return roleFucntion;
	}

}
