package com.cootoo.metamanagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.RepeaterManagementDao;
import com.cootoo.metamanagement.domain.Repeater;

@Repository
public class RepeaterManagementDaoImpl implements RepeaterManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertRepeater(List<Repeater> repeaterList) {
		return sqlSessionTemplate.insert("repeaterModule.insertRepeater", repeaterList);
	}

	@Override
	public int deleteRepeater(List<String> repeaterIDList) {
		return sqlSessionTemplate.delete("repeaterModule.deleteRepeater", repeaterIDList);
	}

	@Override
	public int updateRepeater(Repeater repeater) {
		return sqlSessionTemplate.update("repeaterModule.updateRepeater", repeater);
	}
}
