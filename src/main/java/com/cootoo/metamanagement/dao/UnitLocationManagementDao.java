package com.cootoo.metamanagement.dao;

import java.util.List;
import java.util.Map;

import com.cootoo.metamanagement.domain.UnitLocation;

public interface UnitLocationManagementDao {

	int insertUnitLocation(List<UnitLocation> unitLocationList);
	
	int deleteUnitLocation(List<String> locationIDList);
	
	int updateUnitLocation(UnitLocation unitLocation);
	
	List<Map<String,Object>> selectSchoolAreaByLoginID(int loginID);
	
	List<Map<String,Object>> selectBuildingByLoginID(int loginID);
	
	List<Map<String,Object>> selectFloorOrRoomByLocationID(String locationID);
	
	int selectTreePathByOrgID(String orgID);
}
