package com.cootoo.menuManagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.menuManagement.dao.MenuManagementDao;
import com.cootoo.menuManagement.domain.Function;
import com.cootoo.menuManagement.domain.Menu;
import com.cootoo.menuManagement.domain.Module;

@Repository
public class MenuManagementDaoImpl implements MenuManagementDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Module> getModules() {
		return sqlSessionTemplate.selectList("menuModule.getModules");
	}

	@Override
	public List<Function> getFunctions(int moduleID) {
		return sqlSessionTemplate.selectList("menuModule.getFunctions", moduleID);
	}

	@Override
	public List<Module> getMenus() {
		return sqlSessionTemplate.selectList("menuModule.getMenus");
	}

	@Override
	public Menu selectRoleFunctions(int userID) {
		Menu roleFunction = sqlSessionTemplate.selectOne("menuModule.selectRoleFunctions", userID);
		return roleFunction;
	}



}
