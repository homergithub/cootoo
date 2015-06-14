package com.cootoo.dormManagement.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.dormManagement.dao.DormManagementDao;
import com.cootoo.dormManagement.domain.MoveLocation;
import com.cootoo.dormManagement.domain.People;
import com.cootoo.dormManagement.domain.UserToLocation;
import com.cootoo.metamanagement.domain.UnitLocation;
@Repository
public class DormManagementDaoImpl implements DormManagementDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<People> getAllStudentBySchool(String sex,int orgID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("sex", sex);
		params.put("orgID", orgID);
		return sqlSessionTemplate.selectList("dormModule.getAllStudentBySchool", params);
	}

	@Override
	public List<UnitLocation> getAllDormByOrgID(int orgID,String unitID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgID", orgID);
		params.put("unitID", unitID);
		return sqlSessionTemplate.selectList("dormModule.getAllDormByOrgID", params);
	}

	@Override
	public Map<String, Object> getDormRestSize(int orgID, String locationID) {		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgID", orgID);
		params.put("locationID", locationID);
		return sqlSessionTemplate.selectOne("dormModule.getDormRestSize", params);
	}

	@Override
	public int insertUserToLocation(List<UserToLocation> userToLocations) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userToLocationList", userToLocations);
		return sqlSessionTemplate.insert("dormModule.insertUserToLocation", params);
	}

	@Override
	public int insertMoveLocation(List<MoveLocation> moveLocations) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("moveLocations", moveLocations);
		return sqlSessionTemplate.insert("dormModule.insertMoveLocation", params);
		
	}

	@Override
	public int updatePeopleIsAllocated(String isAllocated, List<String> peopleIDList) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("isAllocated", isAllocated);
		params.put("peopleIDList", peopleIDList);
		return sqlSessionTemplate.update("dormModule.updatePeopleIsAllocated", params);
	}

	@Override
	public int deletePeopleFromUnitLocation(
			List<String> peopleID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("peopleIDList", peopleID);
		return sqlSessionTemplate.delete("dormModule.deletePeopleFromUnitLocation", params);
	}

	@Override
	public Map<String, Object> getPeopleUnitLocation(String peopleID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("peopleID", peopleID);
		return sqlSessionTemplate.selectOne("dormModule.getPeopleUnitLocation", params);
	}

	@Override
	public int updatePeopleUnitLocation(String peopleID, String locationID) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("peopleID", peopleID);
		params.put("locationID", locationID);
		return sqlSessionTemplate.update("dormModule.updatePeopleUnitLocation", params);
	}
	
	
	
}
