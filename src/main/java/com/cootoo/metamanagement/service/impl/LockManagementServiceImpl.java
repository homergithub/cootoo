package com.cootoo.metamanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cootoo.metamanagement.dao.LockManagementDao;
import com.cootoo.metamanagement.domain.Lock;
import com.cootoo.metamanagement.service.LockManagementService;

@Service
public class LockManagementServiceImpl implements LockManagementService {

	@Autowired
	private LockManagementDao lockManagementDaoImpl;

	private final String INSERT_SUCCESS="添加门锁成功!";
	
	private final String MODIFY_SUCCESS="修改门锁成功!";
	
	@Override
	public Map<String, Object> addLock(List<Lock> lockList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		lockManagementDaoImpl.insertLock(lockList);
		result.put("msg", INSERT_SUCCESS);
		return result; 
	}

	@Override
	public Map<String, Object> deleteLock(List<String> lockIDList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		int rows = lockManagementDaoImpl.deleteLock(lockIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}

	@Override
	public Map<String, Object> modifyLock(Lock lock) {
		Map<String,Object> result = new HashMap<String, Object>();		
		lockManagementDaoImpl.updateLock(lock);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}
	
	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条门锁信息";
	}
}
