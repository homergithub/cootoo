package com.cootoo.metamanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.PeopleManagementDao;
import com.cootoo.metamanagement.domain.People;
import com.cootoo.metamanagement.service.PeopleManagementService;

@Service
public class PeopleManagementServiceImpl implements PeopleManagementService {

	@Autowired
	private PeopleManagementDao peopleManagementDaoImpl;

	private final String INSERT_SUCCESS="添加住户成功!";
	
	private final String MODIFY_SUCCESS="修改住户成功!";
	
	
	@Override
	public Map<String, Object> addPeople(List<People> peopleList) {
		Map<String,Object> result = new HashMap<String, Object>();
		peopleManagementDaoImpl.insertPeople(peopleList);
		result.put("msg", INSERT_SUCCESS);
		return result;
	}

	@Override
	public Map<String, Object> deletePeople(List<String> peopleIDList) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = peopleManagementDaoImpl.deletePeople(peopleIDList);
		result.put("msg", getDeleteMsg(rows));
		return result;
	}

	@Override
	public Map<String, Object> modifyPeople(People people) {
		Map<String,Object> result = new HashMap<String, Object>();
		peopleManagementDaoImpl.updatePeople(people);
		result.put("msg", MODIFY_SUCCESS);
		return result;
	}
	
	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条住户信息";
	}
}
