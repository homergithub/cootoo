package com.cootoo.systemmanagement.service;

import java.util.Map;

import com.cootoo.systemmanagement.domain.Login;

public interface SystemManagementService {

	Map<String,Object> login(String loginAccount,String loginPassword);

	Map<String,Object> getUserRoleFunctions(int loginID);
	
	Map<String,Object> getAllRole();
	
	Map<String,Object> addLoginUser(Login login);
}
