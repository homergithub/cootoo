package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.UnitLocation;

public interface UnitLocationManagementDao {

	int insertUnitLocation(List<UnitLocation> unitLocationList);
	
	int deleteUnitLocation(List<String> locationIDList);
	
	int updateUnitLocation(UnitLocation unitLocation);
}
