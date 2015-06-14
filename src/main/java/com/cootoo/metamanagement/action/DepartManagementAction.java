package com.cootoo.metamanagement.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cootoo.metamanagement.domain.Department;
import com.cootoo.metamanagement.service.DepartManagementService;

@RequestMapping(value="/departManagement/")
@Controller
public class DepartManagementAction{

	@Autowired
	private DepartManagementService departManagementServiceImpl;
	
	
	@RequestMapping(value="addDepartment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addDepartment(HttpServletRequest request){
		
		List<Department> departList = new ArrayList<Department>();
		String departmentID = request.getParameter("departmentID");
		String departmentName = request.getParameter("departmentName");
		String departmentPID = request.getParameter("departmentPID");
		String strDepartmentType = request.getParameter("departmentType");
	    Integer departmentType = null;
		if(null != strDepartmentType && !"".equals(strDepartmentType)){
			departmentType = Integer.parseInt(strDepartmentType);
		}
		String departmentPosition = request.getParameter("departmentPosition");
		String departmentDescription = request.getParameter("departmentDescription");
		String orgID = request.getParameter("orgID");
		Department department = new Department(departmentID, departmentName, departmentPID, departmentType, departmentPosition, departmentDescription, orgID);
		departList.add(department);
		Map<String, Object> result = departManagementServiceImpl.addDepartment(departList);		
		return result;
		
	}
}
