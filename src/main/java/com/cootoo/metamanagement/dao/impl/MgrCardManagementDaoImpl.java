package com.cootoo.metamanagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.MgrCardManagementDao;
import com.cootoo.metamanagement.domain.ManagerCard;

@Repository
public class MgrCardManagementDaoImpl implements MgrCardManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertMgrCard(List<ManagerCard> mgrCardList) {
		return sqlSessionTemplate.insert("mgrCardModule.insertMgrCard", mgrCardList);
	}

	@Override
	public int deleteMgrCard(List<String> mgrCardIDList) {
		return sqlSessionTemplate.delete("mgrCardModule.deleteMgrCard", mgrCardIDList);
	}

	@Override
	public int updateMgrCard(ManagerCard mgrCard) {
		return sqlSessionTemplate.update("mgrCardModule.updateMgrCard", mgrCard);
	}

	
}
