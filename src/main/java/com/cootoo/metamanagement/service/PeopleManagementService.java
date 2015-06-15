package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import com.cootoo.metamanagement.domain.People;

public interface PeopleManagementService {

	Map<String,Object> addPeople(List<People> peopleList);
	
	Map<String,Object> deletePeople(List<String> peopleIDList);
	
	Map<String,Object> modifyPeople(People people);
}
