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
import com.cootoo.common.exception.TreePathColumnFormatException;
import com.cootoo.common.imported.UnitLocationImporter;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.dao.UnitLocationManagementDao;
import com.cootoo.metamanagement.domain.UnitLocation;
import com.cootoo.metamanagement.service.UnitLocationManagementService;

@Service
public class UnitLocationManagementServiceImpl implements UnitLocationManagementService {

	private final Logger logger = Logger.getLogger(UnitLocationManagementServiceImpl.class);
	
	@Autowired
	private UnitLocationManagementDao unitLocationManagementDaoImpl;

	
	private final String INSERT_SUCCESS="添加建筑成功!";
	
	private final String MODIFY_SUCCESS="修改建筑成功!";
	
	@Override
	public Map<String,Object> addUnitLocation(List<UnitLocation> unitLocationList) {
		Map<String,Object> result = new HashMap<String, Object>();
		unitLocationManagementDaoImpl.insertUnitLocation(unitLocationList);
		result.put("msg", INSERT_SUCCESS);
		return result;
	}


	@Override
	public Map<String, Object> addUnitLocation(MultipartFile file,String orgID) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		long count = 0l;
		
		if(file!=null){
			// 获得文件名：   
	        String fileName = file.getOriginalFilename();  
	       
	        Workbook workBook = null;
	       	
			try {
				workBook = ExcelUtil.buildWorkbook(file, fileName);
				ExcelUtil<UnitLocation> eu = new UnitLocationImporter();
				List<List<UnitLocation>> content = eu.readExcel(workBook);
				for (List<UnitLocation> list : content) {
					List<String> locationIDList = new ArrayList<String>();
					for (UnitLocation unitLocation : list) {
						locationIDList.add(unitLocation.getLocationID());
					}
					unitLocationManagementDaoImpl.deleteUnitLocation(locationIDList);
					unitLocationManagementDaoImpl.insertUnitLocation(list);
					int treePathNum = unitLocationManagementDaoImpl.selectTreePathByOrgID(orgID);
					if(treePathNum > 0){
						throw new TreePathColumnFormatException("层级关系错误，请重新调整！");
					}
				}
				
			}catch (SexColumnFormatException e) {
				logger.error(e.getMessage(), e);
				msg = "性别字段格式不正确！";
				result.put("msg", msg);
				return result;
			}catch (TreePathColumnFormatException e) {
				logger.error(e.getMessage(), e);
				result.put("msg", e.getMessage());			
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
	public Map<String, Object> deleteUnitLocation(List<String> locationIDList) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = unitLocationManagementDaoImpl.deleteUnitLocation(locationIDList);
		result.put("msg", getDeleteMsg(rows));
		return result;
	}

	
	@Override
	public Map<String, Object> modifyUnitLocation(UnitLocation unitLocation) {
		Map<String,Object> result = new HashMap<String, Object>();
		unitLocationManagementDaoImpl.updateUnitLocation(unitLocation);
		result.put("msg", MODIFY_SUCCESS);
		return result;
	}
	
	
	
	
	
	
	

	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条建筑信息";
	}


	@Override
	public Map<String, Object> getSchoolAreaByLoginID(int loginID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> schoolAreaList = unitLocationManagementDaoImpl.selectSchoolAreaByLoginID(loginID);
		result.put("data", schoolAreaList);
		return result;
	}


	@Override
	public Map<String, Object> getBuildingByLoginID(int loginID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> buildingList = unitLocationManagementDaoImpl.selectBuildingByLoginID(loginID);
		result.put("data", buildingList);
		return result;
	}


	@Override
	public Map<String, Object> getFloorOrRoomByLocationID(String locationID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> floorRoomList = unitLocationManagementDaoImpl.selectFloorOrRoomByLocationID(locationID);
		result.put("data", floorRoomList);
		return result;
	}


	

	


	
	
}
