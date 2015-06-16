package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cootoo.metamanagement.domain.UnitLocation;

public interface UnitLocationManagementService {

	Map<String,Object> addUnitLocation(List<UnitLocation> unitLocationList);
	
	Map<String,Object> addUnitLocation(MultipartFile file,String orgID);
	
	Map<String,Object> deleteUnitLocation(List<String> locationIDList);
	
	Map<String,Object> modifyUnitLocation(UnitLocation unitLocation);
	
	Map<String,Object> getSchoolAreaByLoginID(int loginID);
	
	Map<String,Object> getBuildingByLoginID(int loginID);
	
	Map<String,Object> getFloorOrRoomByLocationID(String locationID);
}
