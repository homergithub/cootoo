package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import com.cootoo.metamanagement.domain.UnitLocation;

public interface UnitLocationManagementService {

	Map<String,Object> addUnitLocation(List<UnitLocation> unitLocationList);
	
	Map<String,Object> deleteUnitLocation(List<String> locationIDList);
	
	Map<String,Object> modifyUnitLocation(UnitLocation unitLocation);
}
