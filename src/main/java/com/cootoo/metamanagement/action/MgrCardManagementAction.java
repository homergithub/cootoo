package com.cootoo.metamanagement.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cootoo.metamanagement.domain.ManagerCard;
import com.cootoo.metamanagement.service.MgrCardManagementService;

@RequestMapping(value="/mgrCardManagement/")
@Controller
public class MgrCardManagementAction{

	@Autowired
	private MgrCardManagementService mgrCardManagementServiceImpl;
	
	@RequestMapping(value="addMgrCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addMgrCard(HttpServletRequest request){
		
		List<ManagerCard> mgrCardList = new ArrayList<ManagerCard>();
		String managerCardID = request.getParameter("managerCardID");
		String managerCardName = request.getParameter("managerCardName");
		String managerType = request.getParameter("managerType");
		String orgID = request.getParameter("orgID");
		ManagerCard mgrCard = new ManagerCard(managerCardID, managerCardName, managerType, orgID);
		mgrCardList.add(mgrCard);
		Map<String, Object> result = mgrCardManagementServiceImpl.addMgrCard(mgrCardList);
		return result;
	}
	
	@RequestMapping(value="managerCardImport",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> managerCardImport(HttpServletRequest request){
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");	
		Map<String, Object> result = mgrCardManagementServiceImpl.addManagerCard(file);	
		return result;
		
	}
	
	@RequestMapping(value="deleteMgrCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteMgrCard(HttpServletRequest request){
		
		String strMgrCardIDs = request.getParameter("mgrCardIDs");
		List<String> mgrCardIDList = Arrays.asList(strMgrCardIDs.split(","));
		Map<String, Object> result = mgrCardManagementServiceImpl.deleteMgrCard(mgrCardIDList);
		return result;
	}
	
	@RequestMapping(value="modifyMgrCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyMgrCard(HttpServletRequest request){
		
		String managerCardID = request.getParameter("managerCardID");
		String managerCardName = request.getParameter("managerCardName");
		String managerType = request.getParameter("managerType");
		String orgID = request.getParameter("orgID");
		ManagerCard mgrCard = new ManagerCard(managerCardID, managerCardName, managerType, orgID);
		Map<String, Object> result = mgrCardManagementServiceImpl.modifyMgrCard(mgrCard);
		return result;
	}
	
}
