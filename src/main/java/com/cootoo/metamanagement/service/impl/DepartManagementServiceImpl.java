package com.cootoo.metamanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.DepartManagementDao;
import com.cootoo.metamanagement.domain.Department;
import com.cootoo.metamanagement.service.DepartManagementService;

@Service
public class DepartManagementServiceImpl implements DepartManagementService {

	@Autowired
	private DepartManagementDao departManagementDaoImpl;

	
	private final String INSERT_SUCCESS="添加部门成功!";
	
	@Override
	public Map<String,Object> addDepartment(List<Department> departList) {
		
		Map<String,Object> result = new HashMap<String, Object>();		
		departManagementDaoImpl.insertDepartment(departList);
		result.put("msg", INSERT_SUCCESS);
		return result; 
		
	}
}
