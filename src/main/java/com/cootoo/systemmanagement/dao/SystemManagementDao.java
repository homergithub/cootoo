package com.cootoo.systemmanagement.dao;

import java.util.List;

import com.cootoo.systemmanagement.domain.Login;
import com.cootoo.systemmanagement.domain.LoginRole;
import com.cootoo.systemmanagement.domain.Role;

public interface SystemManagementDao {

	Login selectLoginUser(String loginAccount,String loginPassword);
	
	LoginRole selectRoleFunctions(int loginID);
	
	List<Role> selectAllRole();
	
	int insertLogin(Login login);
	
}
