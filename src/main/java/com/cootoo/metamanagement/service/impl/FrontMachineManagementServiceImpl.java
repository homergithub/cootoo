package com.cootoo.metamanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.FrontMachineManagementDao;
import com.cootoo.metamanagement.domain.FrontMachine;
import com.cootoo.metamanagement.service.FrontMachineManagementService;

@Service
public class FrontMachineManagementServiceImpl implements
		FrontMachineManagementService {

	@Autowired
	private FrontMachineManagementDao frontMachineManagementDaoImpl;
	
	private final String INSERT_SUCCESS="添加前置服务器成功!";
	
	private final String MODIFY_SUCCESS="修改前置服务器成功!";
	
	@Override
	public Map<String, Object> addFrontMachine(
			List<FrontMachine> frontMachineList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		frontMachineManagementDaoImpl.insertFrontMachine(frontMachineList);
		result.put("msg", INSERT_SUCCESS);
		return result; 
	}

	@Override
	public Map<String, Object> deleteFrontMachine(List<String> machineIDList) {
		Map<String,Object> result = new HashMap<String, Object>();	
		int rows = frontMachineManagementDaoImpl.deleteFrontMachine(machineIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}

	@Override
	public Map<String, Object> modifyFrontMachine(FrontMachine frontMachine) {
		Map<String,Object> result = new HashMap<String, Object>();	
		frontMachineManagementDaoImpl.updateFrontMachine(frontMachine);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}
	

	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条前置服务器信息";
	}

}
