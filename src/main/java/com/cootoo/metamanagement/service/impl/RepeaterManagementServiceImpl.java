package com.cootoo.metamanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.RepeaterManagementDao;
import com.cootoo.metamanagement.domain.Repeater;
import com.cootoo.metamanagement.service.RepeaterManagementService;

@Service
public class RepeaterManagementServiceImpl implements RepeaterManagementService {

	@Autowired
	private RepeaterManagementDao repeaterManagementDaoImpl;

	private final String INSERT_SUCCESS="添加中继成功!";
	
	private final String MODIFY_SUCCESS="修改中继成功!";
	
	@Override
	public Map<String, Object> addRepeater(List<Repeater> repeaterList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		repeaterManagementDaoImpl.insertRepeater(repeaterList);
		result.put("msg", INSERT_SUCCESS);
		return result; 
	}

	@Override
	public Map<String, Object> deleteRepeater(List<String> repeaterIDList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		int rows = repeaterManagementDaoImpl.deleteRepeater(repeaterIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}

	@Override
	public Map<String, Object> modifyRepeater(Repeater repeater) {
		Map<String,Object> result = new HashMap<String, Object>();		
		repeaterManagementDaoImpl.updateRepeater(repeater);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}
	
	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条中继信息";
	}
}
