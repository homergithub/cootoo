package com.cootoo.metamanagement.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cootoo.common.util.DateUtil;
import com.cootoo.metamanagement.domain.Lock;
import com.cootoo.metamanagement.service.LockManagementService;

@RequestMapping(value="/lockManagement/")
@Controller
public class LockManagementAction{

	@Autowired
	private LockManagementService lockManagementServiceImpl;
	
	
	@RequestMapping(value="addLock",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addLock(HttpServletRequest request){
			
		List<Lock> lockList = new ArrayList<Lock>();
		String lockMacID = request.getParameter("lockMacID");
		String lockName = request.getParameter("lockName");
		String locationID = request.getParameter("locationID");
		String isLive = request.getParameter("isLive");
		String repeaterID = request.getParameter("repeaterID");
		Lock lock = new Lock(lockMacID, lockName, locationID, isLive, repeaterID, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), null, null, null);
		lockList.add(lock);
		Map<String, Object> result = lockManagementServiceImpl.addLock(lockList);
		return result;
	}
	
	
	@RequestMapping(value="deleteLock",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteLock(HttpServletRequest request){
		
		String strLockIDs = request.getParameter("lockIDs");
		List<String> lockIDList = Arrays.asList(strLockIDs.split(","));
		Map<String, Object> result = lockManagementServiceImpl.deleteLock(lockIDList);
		return result;
		
	}
	
	
	@RequestMapping(value="modifyLock",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyLock(HttpServletRequest request){
		
		String lockMacID = request.getParameter("lockMacID");
		String lockName = request.getParameter("lockName");
		String locationID = request.getParameter("locationID");
		String isLive = request.getParameter("isLive");
		String repeaterID = request.getParameter("repeaterID");
		Lock lock = new Lock(lockMacID, lockName, locationID, isLive, repeaterID, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), null, null, null);
		
		Map<String, Object> result = lockManagementServiceImpl.modifyLock(lock);
		return result;
	}
	
	
}
