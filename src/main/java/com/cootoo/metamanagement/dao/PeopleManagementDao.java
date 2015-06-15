package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.People;

public interface PeopleManagementDao {

	int insertPeople(List<People> peopleList);
	
	int deletePeople(List<String> peopleIDList);
	
	int updatePeople(People people);
}
