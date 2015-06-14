package com.cootoo.metamanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.UnitLocationManagementDao;
import com.cootoo.metamanagement.domain.UnitLocation;
import com.cootoo.metamanagement.service.UnitLocationManagementService;

@Service
public class UnitLocationManagementServiceImpl implements UnitLocationManagementService {

	@Autowired
	private UnitLocationManagementDao unitLocationManagementDaoImpl;

	
	private final String INSERT_SUCCESS="添加建筑成功!";
	
	private final String MODIFY_SUCCESS="修改建筑成功!";
	
	@Override
	public Map<String,Object> addUnitLocation(List<UnitLocation> unitLocationList) {
		Map<String,Object> result = new HashMap<String, Object>();
		unitLocationManagementDaoImpl.insertUnitLocation(unitLocationList);
		result.put("msg", INSERT_SUCCESS);
		return result;
	}


	@Override
	public Map<String, Object> deleteUnitLocation(List<String> locationIDList) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = unitLocationManagementDaoImpl.deleteUnitLocation(locationIDList);
		result.put("msg", getDeleteMsg(rows));
		return result;
	}

	
	@Override
	public Map<String, Object> modifyUnitLocation(UnitLocation unitLocation) {
		Map<String,Object> result = new HashMap<String, Object>();
		unitLocationManagementDaoImpl.updateUnitLocation(unitLocation);
		result.put("msg", MODIFY_SUCCESS);
		return result;
	}
	
	
	
	
	
	
	

	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条建筑信息";
	}


	
	
}
