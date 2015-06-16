package com.cootoo.systemmanagement.dao;

import java.util.List;
import java.util.Map;

import com.cootoo.systemmanagement.domain.Login;
import com.cootoo.systemmanagement.domain.LoginRole;
import com.cootoo.systemmanagement.domain.Role;

public interface SystemManagementDao {

	Login selectLoginUser(String loginAccount,String loginPassword);
	
	LoginRole selectRoleFunctions(int loginID);
	
	List<Role> selectAllRole();
	
	Map<String,Object> selectLoginRole(String loginAccount);
	
	int insertLogin(Login login);
	
}
