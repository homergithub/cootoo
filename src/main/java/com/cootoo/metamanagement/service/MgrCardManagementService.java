package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cootoo.metamanagement.domain.ManagerCard;

public interface MgrCardManagementService {

	Map<String,Object> addMgrCard(List<ManagerCard> mgrCardList);
	
	Map<String,Object> addManagerCard(MultipartFile file);
	
	Map<String,Object> deleteMgrCard(List<String> mgrCardIDList);
	
	Map<String,Object> modifyMgrCard(ManagerCard mgrCard);
}
