package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.Lock;

public interface LockManagementDao {

	int insertLock(List<Lock> lockList);
	
	int deleteLock(List<String> lockIDList);
	
	int updateLock(Lock lock);
}
