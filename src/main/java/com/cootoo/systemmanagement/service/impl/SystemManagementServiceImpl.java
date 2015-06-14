package com.cootoo.systemmanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.systemmanagement.dao.SystemManagementDao;
import com.cootoo.systemmanagement.domain.Login;
import com.cootoo.systemmanagement.domain.LoginRole;
import com.cootoo.systemmanagement.domain.Role;
import com.cootoo.systemmanagement.service.SystemManagementService;

@Service
public class SystemManagementServiceImpl implements SystemManagementService{

	@Autowired
	private SystemManagementDao systemManagementDaoImpl;
	
	@Override
	public Map<String, Object> login(String loginAccount, String loginPassword) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		String code = "0";
		Login login = systemManagementDaoImpl.selectLoginUser(loginAccount, loginPassword);
		
		if(login==null){
			msg = "用户名或密码错误，请重试";
			result.put("code", code);
			result.put("msg", msg);
			return result;
		}
		code = "1";
		msg = "登录成功";
		result.put("code", code);
		result.put("msg", msg);
		return result;
	}

	@Override
	public Map<String, Object> getUserRoleFunctions(int loginID) {
		
		Map<String,Object> result = new HashMap<String, Object>();	
		LoginRole loginRole = systemManagementDaoImpl.selectRoleFunctions(loginID);
		
		result.put("data", loginRole);
		return result;
		
		
		
	}

	@Override
	public Map<String, Object> getAllRole() {
		
		Map<String,Object> result = new HashMap<String, Object>();		
		List<Role> allRoles = systemManagementDaoImpl.selectAllRole();
		result.put("data", allRoles);
			
		return result;
				
	}

	@Override
	public Map<String, Object> addLoginUser(Login login) {
		Map<String,Object> result = new HashMap<String, Object>();	
		int rows = systemManagementDaoImpl.insertLogin(login);
		result.put("rows", rows);
		result.put("msg","添加成功");
		return result;
	}

}
