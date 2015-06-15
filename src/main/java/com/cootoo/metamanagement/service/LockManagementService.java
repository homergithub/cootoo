package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import com.cootoo.metamanagement.domain.Lock;

public interface LockManagementService {

	Map<String,Object> addLock(List<Lock> lockList);
	
	Map<String,Object> deleteLock(List<String> lockIDList);
	
	Map<String,Object> modifyLock(Lock lock);
	
}
