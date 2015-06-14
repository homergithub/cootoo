package com.cootoo.dormManagement.dao;

import java.util.List;
import java.util.Map;

import com.cootoo.dormManagement.domain.MoveLocation;
import com.cootoo.dormManagement.domain.People;
import com.cootoo.dormManagement.domain.UserToLocation;
import com.cootoo.metamanagement.domain.UnitLocation;

public interface DormManagementDao {

	List<People> getAllStudentBySchool(String sex,int orgID);
	
	List<UnitLocation> getAllDormByOrgID(int orgID,String unitID);
	
	Map<String,Object> getDormRestSize(int orgID,String locationID);
	
	int insertUserToLocation(List<UserToLocation> userToLocations);
	
	int insertMoveLocation(List<MoveLocation> moveLocations);
	
	int updatePeopleIsAllocated(String isAllocated,List<String> peopleIDList);
	
	int deletePeopleFromUnitLocation(List<String> peopleID);
	
	Map<String,Object> getPeopleUnitLocation(String peopleID);
	
	int updatePeopleUnitLocation(String peopleID,String locationID);
}
