package com.cootoo.metamanagement.dao;

import java.util.List;
import java.util.Map;

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

public interface MetaManagementDao {

	List<Location> getAllLocations(int orgID);
	
	int getTreePathByOrgID(int orgID);
	
	UnitLocation getUnitLocationByLocationID(String locationID,int orgID);
	
	UnitLocation getUnitLocationByLocationParent(String locationID,int orgID);
	
	Map<String,Object> getUnitLocationTreePath(String locationID,int orgID);
	
	int updateUnitLocationTreePath(String oldTreePath,String newTreePath,String locationID,int orgID);
	
	int updateAllTreePath(String tempTreePath,String newTreePath,String oldTreePath,int orgID);
	
	int insertUnitLocationList(List<UnitLocation> unitLocations);
	
	int deleteUnitLocationList(List<UnitLocation> unitLocations);
	
	int insertUnitLocation(UnitLocation unitLocation);
	
	int deleteUnitLocation(String[] locationID);
	
	int updateUnitLocation(UnitLocation unitLocation);
	
	int insertRepeater(Repeater repeater);
	
	List<Location> getAllRepeaters(int orgID);
	
	Repeater getRepeater(String repeaterID,int orgID);
	
	List<Location> getRepeaterByLocation(String locationID,int orgID);
	
	int updateRepeater(Repeater repeater);
	
	int deleteRepeater(String repeaterID);
	
	List<Location> getAllLock(int orgID);
	
	Lock getLock(String lockMacID,int orgID);
	
	int insertLock(Lock lock);
	
	int deleteLock(String lockMacID);
	
	List<CardType> getCardType();
	
	int insertCard(Card card);
	
	int insertCardList(List<Card> cards);
	
	int updateLock(Lock lock);
	
	List<Card> getAllCardByOrgID(int orgID,int cardTypeID,int cardName);
	
	int updateCard(Card card);
	
	int deleteCard(String cardMacID);
	
	int deleteCards(List<Card> cards);
	
	int insertPeople(List<People> peoples);
	
	int deletePeople(List<People> peoples);
	
	int insertPeopleToCard(String peopleID,String cardMacID);
	
	int insertDepartment(List<Department> departs);
	
	int deleteDepartments(List<Department> departs);
	
	int insertUserToCard(List<UserToCard> userCards);
	
	int deleteUserToCard(UserToCard userCard);
	
	int insertOrganization(Organization org);
	
	int insertManagerCard(List<ManagerCard> managerCards);
	
	int deleteManagerCard(List<ManagerCard> managerCards);
	
	int insertManagerCardToLocation(List<ManagerCardToLocation> cardLocations);
	
	int deleteManagerCardToLocation(ManagerCardToLocation cardLocation);
}
