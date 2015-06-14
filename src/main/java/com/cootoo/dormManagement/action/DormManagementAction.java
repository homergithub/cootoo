/*Copyright (c) 2015, cootoo and/or its affiliates. All rights reserved.*/
package com.cootoo.dormManagement.action;

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

import com.cootoo.dormManagement.service.DormManagementService;
/**
 * @description 宿舍管理模块控制层 
 * @author Homer
 * @version 1.0
 * @date 2015-05-25
 */
@Controller
@RequestMapping(value="/dormManagement/")
public class DormManagementAction {

	@Autowired
	private DormManagementService dormManagementServiceImpl;
	
	/**
	 * 通过学校代码、性别获取所有学生
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getAllStudentBySchool",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getAllStudentBySchool(HttpServletRequest request){
					
		String sex = request.getParameter("sex");
		//此处应该获取orgID
		
		
	     Map<String, Object> result = dormManagementServiceImpl.getAllStudentBySchool(sex,1);
	     return result;
	}
	
	/**
	 * 宿舍的自动分配
	 * @param request
	 * @return
	 */
	@RequestMapping(value="allocateUnit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> allocateUnit(HttpServletRequest request){
		String peopleUnitIDs = request.getParameter("peopleUnitIDs");
		//此处应该获取orgID
		
		Map<String, Object> result = dormManagementServiceImpl.addAllocateUnit(peopleUnitIDs,1);	
		return result;
	}
	
	/**
	 * 出宿
	 * @param request
	 * @return
	 */
	@RequestMapping(value="removePeopleFromUnitLocation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> removePeopleFromUnitLocation(HttpServletRequest request){
		
		String peopleID = request.getParameter("peopleID");
		String locationID = request.getParameter("locationID");
		
		List<String> peopleIDList = Arrays.asList(peopleID.split(","));
		
		Map<String, Object> result = dormManagementServiceImpl.removePeopleFromUnitLocation(peopleIDList,locationID);
		
		return result;
		
	}
	
	/**
	 * 通过住户ID获取住户房间信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getPeopleUnitLocation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getPeopleUnitLocation(HttpServletRequest request){
		
		String peopleID = request.getParameter("peopleID");
		Map<String, Object> result = dormManagementServiceImpl.getPeopleUnitLocation(peopleID);
		
		return result;
	}
	
	/**
	 * 更新住户的房间信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="updatePeopleUnitLocation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updatePeopleUnitLocation(HttpServletRequest request){
		
		String peopleID = request.getParameter("peopleID");
		String newLocationID = request.getParameter("newLocation");
		String oldLocationID = request.getParameter("oldLocation");
		Map<String, Object> result = dormManagementServiceImpl.updatePeopleUnitLocation(peopleID, newLocationID,oldLocationID);
		return result;
	}
	
	/**
	 * 住户信息导入
	 * @param request
	 * @return
	 */
	@RequestMapping(value="peopleToLocationImport",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> peopleToLocationImport(HttpServletRequest request){

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
	
		Map<String, Object> result = dormManagementServiceImpl.addPeopleToUnitLocation(file);
	
		return result;

	 }
	
	
	/**
	 * 已住人员互调（单人）
	 * @param request
	 * @return
	 */
	@RequestMapping(value="peopleLocationExchange",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> peopleLocationExchange(HttpServletRequest request){
		
		String peopleID = request.getParameter("peopleID");
		String anotherPeopleID = request.getParameter("anotherPeopleID");
		String locationID = request.getParameter("locationID");
		String anotherLocationID = request.getParameter("anotherLocationID");
		
		Map<String, Object> result = dormManagementServiceImpl.updatePeopleLocationExchange(peopleID, locationID, anotherPeopleID, anotherLocationID);
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
