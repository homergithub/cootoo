package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;
import com.cootoo.metamanagement.domain.FrontMachine;

public interface FrontMachineManagementService {

	Map<String,Object> addFrontMachine(List<FrontMachine> frontMachineList);
	
	Map<String,Object> deleteFrontMachine(List<String> machineIDList);
	
	Map<String,Object> modifyFrontMachine(FrontMachine frontMachine);
}
