package com.cootoo.metamanagement.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cootoo.metamanagement.domain.Card;
import com.cootoo.metamanagement.domain.Lock;
import com.cootoo.metamanagement.domain.Organization;
import com.cootoo.metamanagement.domain.Repeater;
import com.cootoo.metamanagement.domain.UnitLocation;

public interface MetaManagementService {

	Map<String,Object> addUnitLocation(MultipartFile file,int orgID);
	
	Map<String,Object> getAllLocations(int orgID);
	
	Map<String,Object> getUnitLocationByLocationID(String locationID,int orgID);
	
	Map<String,Object> getUnitLocationByLocationParent(String locationID,int orgID);
	
	Map<String, Object> addUnitLocation(UnitLocation unitLocation);
	
	Map<String,Object> removeUnitLocation(String[] locationID);
	
	Map<String,Object> updateUnitLocation(UnitLocation unitLocation);
	
	Map<String,Object> addRepeater(Repeater repeater);
	
	Map<String,Object> getAllRepeaters(int orgID);
	
	Map<String,Object> getRepeater(String repeaterID,int orgID);
	
	Map<String,Object> getRepeaterByLocation(String locationID,int orgID);
	
	Map<String,Object> updateRepeater(Repeater repeater);
	
	Map<String,Object> removeRepeater(String repeaterID);
	
	Map<String,Object> getAllLock(int orgID);
	
	Map<String,Object> getLock(String lockMacID,int orgID);
	
	Map<String,Object> addLock(Lock lock);
	
	Map<String,Object> updateLock(Lock lock);
	
	Map<String,Object> deleteLock(String lockMacID);
	
	Map<String,Object> getCardType();
	
	Map<String,Object> addCard(Card card);
	
	Map<String,Object> addCard(MultipartFile file);
	
	Map<String,Object> getAllCardByOrgID(int orgID,int cardTypeID,int cardName);
	
	Map<String,Object> updateCard(Card card);
	
	Map<String,Object> deleteCard(String cardMacID);
	
	Map<String,Object> addPeople(MultipartFile file);
	
	Map<String,Object> addDepartment(MultipartFile file);
	
	Map<String,Object> allocateCard(String peopleID,String cardMacID);
	
	Map<String,Object> addUserToCard(MultipartFile file);
	
	Map<String,Object> addOrgnization(Organization org);
	
	Map<String,Object> addManagerCard(MultipartFile file);
	
	Map<String,Object> addManagerCardToLocation(MultipartFile file);

}
