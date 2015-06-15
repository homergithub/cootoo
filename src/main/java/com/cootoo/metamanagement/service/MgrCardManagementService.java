package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import com.cootoo.metamanagement.domain.ManagerCard;

public interface MgrCardManagementService {

	Map<String,Object> addMgrCard(List<ManagerCard> mgrCardList);
	
	Map<String,Object> deleteMgrCard(List<String> mgrCardIDList);
	
	Map<String,Object> modifyMgrCard(ManagerCard mgrCard);
}
