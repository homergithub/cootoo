package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.FrontMachine;

public interface FrontMachineManagementDao {

	int insertFrontMachine(List<FrontMachine> frontMachineList);
	
	int deleteFrontMachine(List<String> machineIDList);
	
	int updateFrontMachine(FrontMachine frontMachine);
}
