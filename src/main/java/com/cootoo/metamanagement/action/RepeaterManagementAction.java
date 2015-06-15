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
import com.cootoo.metamanagement.domain.Repeater;
import com.cootoo.metamanagement.service.RepeaterManagementService;

@RequestMapping(value="/repeaterManagement/")
@Controller
public class RepeaterManagementAction{

	@Autowired
	private RepeaterManagementService repeaterManagementServiceImpl;
	
	@RequestMapping(value="addRepeater",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addRepeater(HttpServletRequest request){
		
		 List<Repeater> repeaterList = new ArrayList<Repeater>();
		 String repeaterID = request.getParameter("repeaterID");
		 String repeaterName = request.getParameter("repeaterName");
		 String repeaterIP = request.getParameter("repeaterIP");
		 String locationID = request.getParameter("locationID");
		 
		 Repeater repeater = new Repeater(repeaterID, repeaterName, repeaterIP, locationID, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), null, null);
		 repeaterList.add(repeater);
		 
		 Map<String, Object> result = repeaterManagementServiceImpl.addRepeater(repeaterList);
		 
		 return result;
	}
	
	@RequestMapping(value="deleteRepeater",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteRepeater(HttpServletRequest request){
		
		String strRepeaterIDs = request.getParameter("repeaterIDs");
		List<String> repeaterIDList = Arrays.asList(strRepeaterIDs.split(","));
		Map<String, Object> result = repeaterManagementServiceImpl.deleteRepeater(repeaterIDList);
		return result;
	}
	
	@RequestMapping(value="modifyRepeater",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyRepeater(HttpServletRequest request){
		
		 String repeaterID = request.getParameter("repeaterID");
		 String repeaterName = request.getParameter("repeaterName");
		 String repeaterIP = request.getParameter("repeaterIP");
		 String locationID = request.getParameter("locationID");
		 Repeater repeater = new Repeater(repeaterID, repeaterName, repeaterIP, locationID, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), null, null);
		 Map<String, Object> result = repeaterManagementServiceImpl.modifyRepeater(repeater);
		 return result;
	}
}
