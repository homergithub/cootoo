package com.cootoo.metamanagement.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cootoo.metamanagement.domain.FrontMachine;
import com.cootoo.metamanagement.service.FrontMachineManagementService;

@RequestMapping(value="/machineManagement/")
@Controller
public class FrontMachineManagementAction {

	@Autowired
	private FrontMachineManagementService frontMachineManagementServiceImpl;
	
	@RequestMapping(value="addFrontMachine",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addFrontMachine(HttpServletRequest request){
		
		List<FrontMachine> frontMachineList = new ArrayList<FrontMachine>();
		String machineName = request.getParameter("machineName");
		String machineIP = request.getParameter("machineIP");
		String machinePort = request.getParameter("machinePort");
		String locationID = request.getParameter("locationID");
		String isLive = request.getParameter("isLive");
		String machineMark = request.getParameter("machineMark");
		FrontMachine frontMachone = new FrontMachine(machineName, machineIP, machinePort, locationID, isLive, null, machineMark);
		
		frontMachineList.add(frontMachone);
		Map<String, Object> result = frontMachineManagementServiceImpl.addFrontMachine(frontMachineList);
		return result;
		
	}
	
	@RequestMapping(value="deleteFrontMachine",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteFrontMachine(HttpServletRequest request){
		
		String strMachineIDs = request.getParameter("machineIDs");
		List<String> machineIDList = Arrays.asList(strMachineIDs.split(","));
		Map<String, Object> result = frontMachineManagementServiceImpl.deleteFrontMachine(machineIDList);
		return result;
		
		
	}
	
	@RequestMapping(value="modifyFrontMachine",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyFrontMachine(HttpServletRequest request){
		
		String machineName = request.getParameter("machineName");
		String machineIP = request.getParameter("machineIP");
		String machinePort = request.getParameter("machinePort");
		String locationID = request.getParameter("locationID");
		String isLive = request.getParameter("isLive");
		String machineMark = request.getParameter("machineMark");
		FrontMachine frontMachine = new FrontMachine(machineName, machineIP, machinePort, locationID, isLive, null, machineMark);
		Map<String, Object> result = frontMachineManagementServiceImpl.modifyFrontMachine(frontMachine);
		return result;
	}
}
