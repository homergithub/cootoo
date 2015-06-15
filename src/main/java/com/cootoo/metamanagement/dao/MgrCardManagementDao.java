package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.ManagerCard;

public interface MgrCardManagementDao {

	int insertMgrCard(List<ManagerCard> mgrCardList);
	
	int deleteMgrCard(List<String> mgrCardIDList);
	
	int updateMgrCard(ManagerCard mgrCard);
}
