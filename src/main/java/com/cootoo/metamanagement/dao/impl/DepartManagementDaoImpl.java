package com.cootoo.metamanagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.DepartManagementDao;
import com.cootoo.metamanagement.domain.Department;

@Repository
public class DepartManagementDaoImpl implements DepartManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertDepartment(List<Department> departList) {
		return sqlSessionTemplate.insert("departModule.insertDepartment", departList);
	}
}
