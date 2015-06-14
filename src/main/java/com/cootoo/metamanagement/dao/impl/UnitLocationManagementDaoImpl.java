package com.cootoo.metamanagement.dao.impl;

import java.util.List;

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

	
}
