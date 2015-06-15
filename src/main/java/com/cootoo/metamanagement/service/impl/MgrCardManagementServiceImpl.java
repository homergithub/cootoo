package com.cootoo.metamanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.MgrCardManagementDao;
import com.cootoo.metamanagement.domain.ManagerCard;
import com.cootoo.metamanagement.service.MgrCardManagementService;

@Service
public class MgrCardManagementServiceImpl implements MgrCardManagementService {

	@Autowired
	private MgrCardManagementDao mgrCardManagementDaoImpl;
	
	private final String INSERT_SUCCESS="添加管理卡成功!";
	
	private final String MODIFY_SUCCESS="修改管理卡成功!";

	
	@Override
	public Map<String, Object> addMgrCard(List<ManagerCard> mgrCardList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		mgrCardManagementDaoImpl.insertMgrCard(mgrCardList);
		result.put("msg", INSERT_SUCCESS);
		return result; 
	}

	@Override
	public Map<String, Object> deleteMgrCard(List<String> mgrCardIDList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		int rows = mgrCardManagementDaoImpl.deleteMgrCard(mgrCardIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}

	@Override
	public Map<String, Object> modifyMgrCard(ManagerCard mgrCard) {
		Map<String,Object> result = new HashMap<String, Object>();		
		mgrCardManagementDaoImpl.updateMgrCard(mgrCard);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}

	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条管理卡信息";
	}
	
}
