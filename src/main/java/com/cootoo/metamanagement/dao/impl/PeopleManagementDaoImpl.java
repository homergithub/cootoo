package com.cootoo.metamanagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.PeopleManagementDao;
import com.cootoo.metamanagement.domain.People;

@Repository
public class PeopleManagementDaoImpl implements PeopleManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertPeople(List<People> peopleList) {
		return sqlSessionTemplate.insert("peopleModule.insertPeople", peopleList);
	}

	@Override
	public int deletePeople(List<String> peopleIDList) {
		return sqlSessionTemplate.delete("peopleModule.deletePeople", peopleIDList);
	}

	@Override
	public int updatePeople(People people) {
		return sqlSessionTemplate.update("peopleModule.updatePeople", people);
	}
}
