package com.cootoo.metamanagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.LockManagementDao;
import com.cootoo.metamanagement.domain.Lock;

@Repository
public class LockManagementDaoImpl implements LockManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertLock(List<Lock> lockList) {
		return sqlSessionTemplate.insert("lockModule.insertLock", lockList);
	}

	@Override
	public int deleteLock(List<String> lockIDList) {
		return sqlSessionTemplate.delete("lockModule.deleteLock", lockIDList);
	}

	@Override
	public int updateLock(Lock lock) {
		return sqlSessionTemplate.update("lockModule.updateLock", lock);
	}
}
