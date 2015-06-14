package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import com.cootoo.metamanagement.domain.Department;

public interface DepartManagementService {

	Map<String,Object> addDepartment(List<Department> departList);
}
