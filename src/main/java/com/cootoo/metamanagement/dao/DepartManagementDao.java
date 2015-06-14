package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.Department;

public interface DepartManagementDao {

	int insertDepartment(List<Department> departList);
}
