package com.cootoo.systemmanagement.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.systemmanagement.dao.SystemManagementDao;
import com.cootoo.systemmanagement.domain.Login;
import com.cootoo.systemmanagement.domain.LoginRole;
import com.cootoo.systemmanagement.domain.Role;

@Repository
public class SystemManagementDaoImpl implements SystemManagementDao{

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Login selectLoginUser(String loginAccount, String loginPassword) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("loginAccount", loginAccount);
		params.put("loginPassword", loginPassword);
		Login login = sqlSessionTemplate.selectOne("systemModule.selectLoginUser", params);
		return login;
		
	}

	@Override
	public LoginRole selectRoleFunctions(int loginID) {
		return sqlSessionTemplate.selectOne("systemModule.selectRoleFunctions", loginID);
	}

	@Override
	public List<Role> selectAllRole() {
		return sqlSessionTemplate.selectList("systemModule.selectAllRole");
	}

	@Override
	public int insertLogin(Login login) {
		return sqlSessionTemplate.insert("systemModule.insertLogin", login);
	}


}
