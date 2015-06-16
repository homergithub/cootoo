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

import com.cootoo.metamanagement.domain.People;
import com.cootoo.metamanagement.service.PeopleManagementService;

@RequestMapping(value="/peopleManagement/")
@Controller
public class PeopleManagementAction{

	@Autowired
	private PeopleManagementService peopleManagementServiceImpl;
	
	
	@RequestMapping(value="addPeople",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addPeople(HttpServletRequest request){
		
		List<People> peopleList = new ArrayList<People>();
		
		String peopleID = request.getParameter("peopleID");
		String peopleName = request.getParameter("peopleName");
		String strPeopleTypeID = request.getParameter("peopleTypeID");
		Integer peopleTypeID = null;
		if(null != strPeopleTypeID && !"".equals(strPeopleTypeID)){
			peopleTypeID = Integer.parseInt(strPeopleTypeID);
		}
		
		String strPeopleSignID = request.getParameter("peopleSignID");
		Integer peopleSignID = null;
		if(null != strPeopleSignID && !"".equals(strPeopleSignID)){
			peopleSignID = Integer.parseInt(strPeopleSignID);
		}
		
		String peopleTel = request.getParameter("peopleTel");
		String departmentID = request.getParameter("departmentID");
		String mark = request.getParameter("mark");
		String isAllocated = request.getParameter("isAllocated");
		String sex = request.getParameter("sex");
		String isInSchool = request.getParameter("isInSchool");
		
		People people = new People(peopleID, peopleName, sex, peopleTel, peopleTypeID, peopleSignID, departmentID, mark, isAllocated, isInSchool);
		peopleList.add(people);
		Map<String, Object> result = peopleManagementServiceImpl.addPeople(peopleList);
		return result;
				
	}
	
	
	@RequestMapping(value="importPeople",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> importPeople(HttpServletRequest request){

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
	
		Map<String, Object> result = peopleManagementServiceImpl.addPeople(file);	
		return result;

	 }
	
	
	@RequestMapping(value="deletePeople",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deletePeople(HttpServletRequest request){
		
		String strPeopleIDs = request.getParameter("peopleIDs");
		List<String> peopleIDList = Arrays.asList(strPeopleIDs.split(","));
		Map<String, Object> result = peopleManagementServiceImpl.deletePeople(peopleIDList);
		return result;			
	}
	
	
	
	@RequestMapping(value="modifyPeople",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyPeople(HttpServletRequest request){	
		
		String peopleID = request.getParameter("peopleID");
		String peopleName = request.getParameter("peopleName");
		String strPeopleTypeID = request.getParameter("peopleTypeID");
		Integer peopleTypeID = null;
		if(null != strPeopleTypeID && !"".equals(strPeopleTypeID)){
			peopleTypeID = Integer.parseInt(strPeopleTypeID);
		}
		
		String strPeopleSignID = request.getParameter("peopleSignID");
		Integer peopleSignID = null;
		if(null != strPeopleSignID && !"".equals(strPeopleSignID)){
			peopleSignID = Integer.parseInt(strPeopleSignID);
		}
		
		String peopleTel = request.getParameter("peopleTel");
		String departmentID = request.getParameter("departmentID");
		String mark = request.getParameter("mark");
		String isAllocated = request.getParameter("isAllocated");
		String sex = request.getParameter("sex");
		String isInSchool = request.getParameter("isInSchool");
		
		People people = new People(peopleID, peopleName, sex, peopleTel, peopleTypeID, peopleSignID, departmentID, mark, isAllocated, isInSchool);	
		Map<String, Object> result = peopleManagementServiceImpl.modifyPeople(people);	
		return result;	
		
	}
	
	
	
	
	
	
	
}
