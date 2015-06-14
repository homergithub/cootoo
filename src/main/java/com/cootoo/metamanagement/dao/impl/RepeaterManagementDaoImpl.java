package com.cootoo.metamanagement.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.RepeaterManagementDao;

@Repository
public class RepeaterManagementDaoImpl implements RepeaterManagementDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
}
