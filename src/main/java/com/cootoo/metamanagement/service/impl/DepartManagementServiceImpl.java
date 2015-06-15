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
	
	private final String MODIFY_SUCCESS="修改部门成功!";
	
	@Override
	public Map<String,Object> addDepartment(List<Department> departList) {
		
		Map<String,Object> result = new HashMap<String, Object>();		
		departManagementDaoImpl.insertDepartment(departList);
		result.put("msg", INSERT_SUCCESS);
		return result; 
		
	}

	@Override
	public Map<String, Object> deleteDepartment(List<String> departIDList) {
		
		Map<String,Object> result = new HashMap<String, Object>();	
		int rows = departManagementDaoImpl.deleteDepartment(departIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}
	
	
	@Override
	public Map<String, Object> modifyDepartment(Department department) {
		
		Map<String,Object> result = new HashMap<String, Object>();	
		departManagementDaoImpl.updateDepartment(department);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}
	
	
	
	
	
	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条部门信息";
	}
}
