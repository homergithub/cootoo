package com.cootoo.metamanagement.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.UnitLocationManagementDao;
import com.cootoo.metamanagement.domain.UnitLocation;

@Repository
public class UnitLocationManagementDaoImpl implements UnitLocationManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertUnitLocation(List<UnitLocation> unitLocationList) {
		return sqlSessionTemplate.insert("unitLocationModule.insertUnitLocation", unitLocationList);
	}

	@Override
	public int deleteUnitLocation(List<String> locationIDList) {
		return sqlSessionTemplate.delete("unitLocationModule.deleteUnitLocation", locationIDList);
	}

	@Override
	public int updateUnitLocation(UnitLocation unitLocation) {
		return sqlSessionTemplate.update("unitLocationModule.updateUnitLocation", unitLocation);
	}

	@Override
	public List<Map<String, Object>> selectSchoolAreaByLoginID(int loginID) {
		return sqlSessionTemplate.selectList("unitLocationModule.selectSchoolAreaByLoginID", loginID);
	}

	@Override
	public List<Map<String, Object>> selectBuildingByLoginID(int loginID) {
		return sqlSessionTemplate.selectList("unitLocationModule.selectBuildingByLoginID", loginID);
	}

	@Override
	public List<Map<String, Object>> selectFloorOrRoomByLocationID(String locationID) {
		return sqlSessionTemplate.selectList("unitLocationModule.selectFloorORRoomByLocationID", locationID);
	}

	@Override
	public int selectTreePathByOrgID(String orgID) {
		return sqlSessionTemplate.selectOne("unitLocationModule.selectTreePathByOrgID", orgID);
	}

	
}
