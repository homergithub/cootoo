package com.cootoo.dormManagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface DormManagementService {

	Map<String,Object> getAllStudentBySchool(String sex,int orgID); 
	
	Map<String,Object> addAllocateUnit(String jsonStr,int orgID);
	
	Map<String,Object> removePeopleFromUnitLocation(List<String> peopleID,String locationID);
	
	Map<String,Object> getPeopleUnitLocation(String peopleID);
	
	Map<String,Object> updatePeopleUnitLocation(String peopleID,String newLocationID,String oldLocationID);
	
	Map<String,Object> addPeopleToUnitLocation(MultipartFile file);
	
	Map<String,Object> updatePeopleLocationExchange(String peopleID,String locationID,String anotherPeopleID,String anotherLocationID);
}
