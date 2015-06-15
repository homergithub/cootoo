package com.cootoo.metamanagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cootoo.metamanagement.dao.FrontMachineManagementDao;
import com.cootoo.metamanagement.domain.FrontMachine;

@Repository
public class FrontMachineManagementDaoImpl implements FrontMachineManagementDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertFrontMachine(List<FrontMachine> frontMachineList) {
		return sqlSessionTemplate.insert("machineModule.insertFrontMachine", frontMachineList);
	}

	@Override
	public int deleteFrontMachine(List<String> machineIDList) {
		return sqlSessionTemplate.delete("machineModule.deleteFrontMachine", machineIDList);
	}

	@Override
	public int updateFrontMachine(FrontMachine frontMachine) {
		return sqlSessionTemplate.update("machineModule.updateFrontMachine", frontMachine);
	}

}
