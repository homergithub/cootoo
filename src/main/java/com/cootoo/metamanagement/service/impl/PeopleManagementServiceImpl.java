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

import com.cootoo.common.exception.SexColumnFormatException;
import com.cootoo.common.imported.PeopleImporter;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.dao.PeopleManagementDao;
import com.cootoo.metamanagement.domain.People;
import com.cootoo.metamanagement.service.PeopleManagementService;

@Service
public class PeopleManagementServiceImpl implements PeopleManagementService {

	private final Logger logger = Logger.getLogger(PeopleManagementServiceImpl.class);
	
	@Autowired
	private PeopleManagementDao peopleManagementDaoImpl;

	private final String INSERT_SUCCESS="添加住户成功!";
	
	private final String MODIFY_SUCCESS="修改住户成功!";
	
	
	@Override
	public Map<String, Object> addPeople(List<People> peopleList) {
		Map<String,Object> result = new HashMap<String, Object>();
		peopleManagementDaoImpl.insertPeople(peopleList);
		result.put("msg", INSERT_SUCCESS);
		return result;
	}
	
	@Override
	public Map<String, Object> addPeople(MultipartFile file) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		long count = 0l;
		
		if(file!=null){
			// 获得文件名：   
	        String fileName = file.getOriginalFilename();  
			Workbook workBook = null;
		       	
			try {
				
				workBook = ExcelUtil.buildWorkbook(file, fileName);
				ExcelUtil<People> eu = new PeopleImporter();
				List<List<People>> content = eu.readExcel(workBook);
				for (List<People> list : content) {
					List<String> peopleIDList = new ArrayList<String>();
					for (People people : list) {
						peopleIDList.add(people.getPeopleID());
					}
					peopleManagementDaoImpl.deletePeople(peopleIDList);
					count += peopleManagementDaoImpl.insertPeople(list);
				}
				
			}catch (SexColumnFormatException e) {
				logger.error(e.getMessage(), e);
				msg = "性别字段格式不正确！";
				result.put("msg", msg);
				return result;
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
	public Map<String, Object> deletePeople(List<String> peopleIDList) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = peopleManagementDaoImpl.deletePeople(peopleIDList);
		result.put("msg", getDeleteMsg(rows));
		return result;
	}

	@Override
	public Map<String, Object> modifyPeople(People people) {
		Map<String,Object> result = new HashMap<String, Object>();
		peopleManagementDaoImpl.updatePeople(people);
		result.put("msg", MODIFY_SUCCESS);
		return result;
	}
	
	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条住户信息";
	}

	
}
