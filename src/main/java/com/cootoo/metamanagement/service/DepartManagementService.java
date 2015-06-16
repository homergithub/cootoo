package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cootoo.metamanagement.domain.Department;

public interface DepartManagementService {

	Map<String,Object> addDepartment(List<Department> departList);
	
	Map<String,Object> addDepartment(MultipartFile file);
	
	Map<String,Object> deleteDepartment(List<String> departIDList);
	
	Map<String,Object> modifyDepartment(Department department);
}
