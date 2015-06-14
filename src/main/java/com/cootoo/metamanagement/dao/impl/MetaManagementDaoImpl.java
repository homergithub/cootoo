package com.cootoo.metamanagement.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.MetaManagementDao;
import com.cootoo.metamanagement.domain.Card;
import com.cootoo.metamanagement.domain.CardType;
import com.cootoo.metamanagement.domain.Department;
import com.cootoo.metamanagement.domain.Location;
import com.cootoo.metamanagement.domain.Lock;
import com.cootoo.metamanagement.domain.ManagerCard;
import com.cootoo.metamanagement.domain.ManagerCardToLocation;
import com.cootoo.metamanagement.domain.Organization;
import com.cootoo.metamanagement.domain.People;
import com.cootoo.metamanagement.domain.Repeater;
import com.cootoo.metamanagement.domain.UnitLocation;
import com.cootoo.metamanagement.domain.UserToCard;

@Repository
public class MetaManagementDaoImpl implements MetaManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Location> getAllLocations(int orgID) {
		return sqlSessionTemplate.selectList("metaModule.getAllLocations",orgID);
	}
	
	@Override
	public int insertUnitLocationList(List<UnitLocation> unitLocations) {
		return sqlSessionTemplate.insert("metaModule.insertUnitLocationList", unitLocations);
	}

	@Override
	public int deleteUnitLocationList(List<UnitLocation> unitLocations) {
		return sqlSessionTemplate.delete("metaModule.deleteUnitLocationList", unitLocations);
	}
	
	

	@Override
	public int insertUnitLocation(UnitLocation unitLocation) {
		return sqlSessionTemplate.insert("metaModule.insertUnitLocation", unitLocation);
	}

	@Override
	public int deleteUnitLocation(String[] locationID) {
		return sqlSessionTemplate.delete("metaModule.deleteUnitLocation", locationID);
	}

	@Override
	public int insertRepeater(Repeater repeater) {
		return sqlSessionTemplate.insert("metaModule.insertRepeater", repeater);
	}

	@Override
	public List<Location> getAllRepeaters(int orgID) {
		return sqlSessionTemplate.selectList("metaModule.getAllRepeater", orgID);
	}

	@Override
	public Repeater getRepeater(String repeaterID,int orgID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgID", orgID);
		params.put("repeaterID", repeaterID);
		return sqlSessionTemplate.selectOne("metaModule.getRepeater", params);
	}

	@Override
	public int updateRepeater(Repeater repeater) {
		return sqlSessionTemplate.update("metaModule.updateRepeater", repeater);
	}

	@Override
	public int deleteRepeater(String repeaterID) {
		return sqlSessionTemplate.delete("metaModule.deleteRepeater", repeaterID);
	}

	@Override
	public int insertLock(Lock lock) {
		return sqlSessionTemplate.insert("metaModule.insertLock", lock);
	}

	@Override
	public List<CardType> getCardType() {
		return sqlSessionTemplate.selectList("metaModule.getCardType");
	}

	@Override
	public int insertCard(Card card) {
		return sqlSessionTemplate.insert("metaModule.insertCard", card);
	}

	@Override
	public List<Location> getRepeaterByLocation(String locationID,int orgID) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("locationID", locationID);
		params.put("orgID", orgID);
		return sqlSessionTemplate.selectList("metaModule.getRepeaterByLocation", params);
	}

	@Override
	public int updateUnitLocation(UnitLocation unitLocation) {
		return sqlSessionTemplate.update("metaModule.updateUnitLocation", unitLocation);
	}

	@Override
	public int updateLock(Lock lock) {
		return sqlSessionTemplate.update("metaModule.updateLock", lock);
	}

	@Override
	public UnitLocation getUnitLocationByLocationID(String locationID, int orgID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("locationID", locationID);
		params.put("orgID",orgID);
		return sqlSessionTemplate.selectOne("metaModule.getUnitLocationByLocationID", params);
	}

	@Override
	public UnitLocation getUnitLocationByLocationParent(String locationID,
			int orgID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("locationID", locationID);
		params.put("orgID",orgID);
		return sqlSessionTemplate.selectOne("metaModule.getUnitLocationByLocationParent", params);
		
	}

	@Override
	public int deleteLock(String lockMacID) {
		return sqlSessionTemplate.delete("metaModule.deleteLock", lockMacID);
	}

	@Override
	public List<Card> getAllCardByOrgID(int orgID,int cardTypeID,int cardName) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgID", orgID);
		params.put("cardTypeID",cardTypeID);
		params.put("cardName",cardName);
		return sqlSessionTemplate.selectList("metaModule.getAllCardByOrgID", params);
	}

	@Override
	public int updateCard(Card card) {
		return sqlSessionTemplate.update("metaModule.updateCard", card);
	}

	@Override
	public int deleteCard(String cardMacID) {
		return sqlSessionTemplate.delete("metaModule.deleteCard", cardMacID);
	}

	@Override
	public List<Location> getAllLock(int orgID) {
		return sqlSessionTemplate.selectList("metaModule.getAllLock", orgID);
	}

	@Override
	public Lock getLock(String lockMacID, int orgID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgID", orgID);
		params.put("lockMacID",lockMacID);
		return sqlSessionTemplate.selectOne("metaModule.getLock", params);
		
	}

	@Override
	public Map<String, Object> getUnitLocationTreePath(String locationID,
			int orgID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgID", orgID);
		params.put("locationID",locationID);
		return sqlSessionTemplate.selectOne("metaModule.getUnitLocationTreePath", params);
	}

	@Override
	public int updateUnitLocationTreePath(String oldTreePath,String newTreePath, String locationID,
			int orgID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgID", orgID);
		params.put("locationID",locationID);
		params.put("oldTreePath", oldTreePath);
		params.put("newTreePath", newTreePath);
		return sqlSessionTemplate.update("metaModule.updateUnitLocationTreePath", params);
	}

	@Override
	public int updateAllTreePath(String tempTreePath,String newTreePath,String oldTreePath,int orgID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgID", orgID);
		params.put("tempTreePath", tempTreePath);
		params.put("newTreePath",newTreePath);
		params.put("oldTreePath", oldTreePath);
		return sqlSessionTemplate.update("metaModule.updateAllTreePath", params);
	}

	@Override
	public int insertPeople(List<People> peoples) {
		return sqlSessionTemplate.insert("metaModule.insertPeople", peoples);
	}

	@Override
	public int deletePeople(List<People> peoples) {
		return sqlSessionTemplate.delete("metaModule.deletePeople", peoples);
	}

	@Override
	public int insertPeopleToCard(String peopleID, String cardMacID) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("peopleID", peopleID);
		params.put("cardMacID", cardMacID);
		return sqlSessionTemplate.insert("metaModule.insertPeopleToCard", params);
	}

	@Override
	public int getTreePathByOrgID(int orgID) {
		return sqlSessionTemplate.selectOne("metaModule.getTreePathByOrgID", orgID);
	}

	@Override
	public int insertCardList(List<Card> cards) {
		return sqlSessionTemplate.insert("metaModule.insertCardList", cards);
	}

	@Override
	public int insertDepartment(List<Department> departs) {
		return sqlSessionTemplate.insert("metaModule.insertDepartment", departs);
	}

	@Override
	public int deleteDepartments(List<Department> departs) {
		return sqlSessionTemplate.delete("metaModule.deleteDepartments", departs);
	}

	@Override
	public int deleteCards(List<Card> cards) {
		return sqlSessionTemplate.delete("metaModule.deleteCards", cards);
	}

	@Override
	public int insertUserToCard(List<UserToCard> userCards) {
		return sqlSessionTemplate.insert("metaModule.insertUserToCard", userCards);
	}

	@Override
	public int deleteUserToCard(UserToCard userCard) {
		return sqlSessionTemplate.delete("metaModule.deleteUserToCard", userCard);
	}

	@Override
	public int insertOrganization(Organization org) {
		return sqlSessionTemplate.insert("metaModule.insertOrganization", org);
	}

	@Override
	public int insertManagerCard(List<ManagerCard> managerCards) {
		return sqlSessionTemplate.insert("metaModule.insertManagerCard", managerCards);
	}

	@Override
	public int insertManagerCardToLocation(
			List<ManagerCardToLocation> cardLocations) {
		return sqlSessionTemplate.insert("metaModule.insertManagerCardToLocation", cardLocations);
	}

	@Override
	public int deleteManagerCard(List<ManagerCard> managerCards) {
		return sqlSessionTemplate.delete("metaModule.deleteManagerCard", managerCards);
	}

	@Override
	public int deleteManagerCardToLocation(ManagerCardToLocation cardLocation) {
		return sqlSessionTemplate.delete("metaModule.deleteManagerCardToLocation", cardLocation);
	}

	

}
