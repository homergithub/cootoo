package com.cootoo.metamanagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cootoo.common.imported.DepartmentImporter;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.dao.DepartManagementDao;
import com.cootoo.metamanagement.domain.Department;
import com.cootoo.metamanagement.service.DepartManagementService;

@Service
public class DepartManagementServiceImpl implements DepartManagementService {

	private final Logger logger = Logger.getLogger(DepartManagementServiceImpl.class);
	
	@Autowired
	private DepartManagementDao departManagementDaoImpl;

	
	private final String INSERT_SUCCESS="添加部门成功!";
	
	private final String MODIFY_SUCCESS="修改部门成功!";
	
	@Override
	public Map<String,Object> addDepartment(List<Department> departList) {
		
		Map<String,Object> result = new HashMap<String, Object>();		
		departManagementDaoImpl.insertDepartment(departList);
		result.put("msg", INSERT_SUCCESS);
		return result; 
		
	}
	
	@Override
	public Map<String, Object> addDepartment(MultipartFile file) {
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		long count = 0l;
		
		if(file!=null){
			// 获得文件名：   
	        String fileName = file.getOriginalFilename();  
			Workbook workBook = null;
		       	
			try {
				
				workBook = ExcelUtil.buildWorkbook(file, fileName);
				ExcelUtil<Department> eu = new DepartmentImporter();
				List<List<Department>> content = eu.readExcel(workBook);
				for (List<Department> list : content) {	
					List<String> departIDList = new ArrayList<String>();
					for (Department department : list) {
						departIDList.add(department.getDepartmentID());
					}
					departManagementDaoImpl.deleteDepartment(departIDList);
					count += departManagementDaoImpl.insertDepartment(list);
				}
				
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				msg = "导入失败，请检查表格中是否有错误的格式！";			
				result.put("msg", msg);			
				return result;
			}
			msg = "导入成功,共导入"+count+"条数据";
			
		}else{
			msg = "请选择文件";
		}
		
        result.put("msg", msg);
		
		return result;
	}

	@Override
	public Map<String, Object> deleteDepartment(List<String> departIDList) {
		
		Map<String,Object> result = new HashMap<String, Object>();	
		int rows = departManagementDaoImpl.deleteDepartment(departIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}
	
	
	@Override
	public Map<String, Object> modifyDepartment(Department department) {
		
		Map<String,Object> result = new HashMap<String, Object>();	
		departManagementDaoImpl.updateDepartment(department);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}
	
	
	
	
	
	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条部门信息";
	}

	
}
