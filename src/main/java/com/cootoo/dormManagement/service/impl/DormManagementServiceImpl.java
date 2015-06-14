package com.cootoo.dormManagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.cootoo.common.imported.UserToLocationImporter;
import com.cootoo.common.util.DateUtil;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.dormManagement.dao.DormManagementDao;
import com.cootoo.dormManagement.domain.MoveLocation;
import com.cootoo.dormManagement.domain.People;
import com.cootoo.dormManagement.domain.UserToLocation;
import com.cootoo.dormManagement.service.DormManagementService;
import com.cootoo.metamanagement.domain.UnitLocation;

@Service
public class DormManagementServiceImpl implements DormManagementService{

	private final Logger logger = Logger.getLogger(DormManagementServiceImpl.class);
	
	@Autowired
	private DormManagementDao dormManagementDaoImpl;

	
	@Override
	public Map<String, Object> getAllStudentBySchool(String sex,int orgID) {
		
		Map<String,Object> result = new HashMap<String, Object>();	
		
	    List<People> students = dormManagementDaoImpl.getAllStudentBySchool(sex,orgID);
			
		result.put("data", students);
		return result;
	}

	@Override
	public Map<String, Object> addAllocateUnit(String jsonStr,int orgID) {
		
		//json字符格式如下:[[1,2,3],[4,5,6,7]]
		
		Map<String,Object> result = new HashMap<String, Object>();
		List<String> jsonArray = JSON.parseArray(jsonStr, String.class);
		String msg = "";	
		for (String string : jsonArray) {
			//空床铺计数器
			long restSize = 0;
			
			List<String> parseArray = JSON.parseArray(string, String.class);
			//获取每组的locationID
			String locationID = parseArray.get(parseArray.size()-1);
			//获取此组所有的peopleID
			List<String> peopleID = parseArray.subList(0, parseArray.size()-1);
			
			//获取location下的房间的床铺数，如果房间床铺数小于peopleID,那么不分配这批人，并且给出提示
			
			//得到此locationID下的所有房间
			List<UnitLocation> allDorm = dormManagementDaoImpl.getAllDormByOrgID(1, locationID);
			//遍历所有房间，判断此房间空床铺数
			for (UnitLocation unitLocation : allDorm) {
				String lid = unitLocation.getLocationID();
				restSize += (long)dormManagementDaoImpl.getDormRestSize(orgID, lid).get("restSize");
			}
			
			if(peopleID.size() > restSize){
				msg += locationID+"此组人数大于空床铺数"+locationID+":"+peopleID;
				continue;
			}
			//如果人数小于等于空床铺数，得到此组locaitonID下所有的房间号
			List<UnitLocation> unitLocations = dormManagementDaoImpl.getAllDormByOrgID(orgID, locationID);
			
			List<String> peopleIDList = new ArrayList<String>();
			List<MoveLocation> moveLocations = new ArrayList<MoveLocation>();
			List<UserToLocation> userToLocations = new ArrayList<UserToLocation>();
			//循环遍历得到每个房间以及此房间剩余床铺数，把peopleID中的人分配到此locationID中
			for (UnitLocation unitLocation : unitLocations) {
				//得到此房间到ID
				String lId = unitLocation.getLocationID();
				//判断此房间下的剩余床铺数
				long dormRestSize = (long) dormManagementDaoImpl.getDormRestSize(orgID, lId).get("restSize");
				//从peopleID中分配dormRestSize个人到lId中
				for (int i = 0; i < dormRestSize && peopleID.size() > 0; i++) {
					String pId = peopleID.remove(0);
					UserToLocation userToLocation = new UserToLocation(pId, lId, "1");
					userToLocations.add(userToLocation);
					//dormManagementDaoImpl.insertUserToLocation(pId, lId, "1");
					//更新tPeople表中的isAllocated
					peopleIDList.add(pId);
					MoveLocation moveLocation = new MoveLocation("新生入宿", pId, null, lId,DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), 1);
					moveLocations.add(moveLocation);				
					//dormManagementDaoImpl.insertMoveLocation("新生入宿", pId, null, lId, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), 1);
				}		
			}
			dormManagementDaoImpl.insertUserToLocation(userToLocations);
			dormManagementDaoImpl.updatePeopleIsAllocated("1", peopleIDList);
			dormManagementDaoImpl.insertMoveLocation(moveLocations);

		}


		result.put("msg", msg);
		return result;
	}

	@Override
	public Map<String, Object> removePeopleFromUnitLocation(List<String> peopleID,String locationID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<MoveLocation> moveLocations = new ArrayList<MoveLocation>();
					
		for (String pId : peopleID) {
			MoveLocation moveLocation = new MoveLocation("出宿", pId, locationID, null, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), 0);
			moveLocations.add(moveLocation);
		}
		
		dormManagementDaoImpl.updatePeopleIsAllocated("0", peopleID);
		
		int rows = dormManagementDaoImpl.deletePeopleFromUnitLocation(peopleID);
		//更新异动表
		dormManagementDaoImpl.insertMoveLocation(moveLocations);
		
		result.put("rows", rows);
		result.put("msg", "出宿成功");
		return result;
	}

	@Override
	public Map<String, Object> getPeopleUnitLocation(String peopleID) {
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String, Object> people = dormManagementDaoImpl.getPeopleUnitLocation(peopleID);
		result.put("data", people);
		return result;
	}

	@Override
	public Map<String, Object> updatePeopleUnitLocation(String peopleID,String newLocationID,String oldLocationID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<MoveLocation> moveLocations = null;
		int rows = dormManagementDaoImpl.updatePeopleUnitLocation(peopleID, newLocationID);
		
		if(!newLocationID.equals(oldLocationID)){
			moveLocations = new ArrayList<MoveLocation>();
			MoveLocation moveLocation = new MoveLocation("宿舍调换", peopleID, oldLocationID, newLocationID, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), 2);
			moveLocations.add(moveLocation);
			dormManagementDaoImpl.insertMoveLocation(moveLocations);
		}
		
		result.put("rows", rows);
		result.put("msg", "宿舍调整成功");
		return result;
	}

	@Override
	public Map<String, Object> addPeopleToUnitLocation(MultipartFile file) {
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		long count = 0l;
		
		if(file!=null){
			// 获得文件名：   
	        String fileName = file.getOriginalFilename();  
			Workbook workBook = null;
		       	
			try {
				
				workBook = ExcelUtil.buildWorkbook(file, fileName);
				ExcelUtil<UserToLocation> eu = new UserToLocationImporter();
				List<List<UserToLocation>> content = eu.readExcel(workBook);
				List<String> peopleIDs = new ArrayList<String>();
				List<MoveLocation> moveLocations = new ArrayList<MoveLocation>();
				for (List<UserToLocation> list : content) {
					for (UserToLocation userToLocation : list) {			
						peopleIDs.add(userToLocation.getPeopleID());
						MoveLocation moveLocation = new MoveLocation("非新生信息导入", userToLocation.getPeopleID(), userToLocation.getLocationID(), userToLocation.getLocationID(), DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), 1);
						moveLocations.add(moveLocation);
					}
					//删除重复记录
					dormManagementDaoImpl.deletePeopleFromUnitLocation(peopleIDs);
					//导入
					count += dormManagementDaoImpl.insertUserToLocation(list);
					//更新people表
					dormManagementDaoImpl.updatePeopleIsAllocated("1", peopleIDs);
					//更新异动表
					dormManagementDaoImpl.insertMoveLocation(moveLocations);
					
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
	public Map<String, Object> updatePeopleLocationExchange(String peopleID,
			String locationID, String anotherPeopleID, String anotherLocationID) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		List<MoveLocation> moveLocations = new ArrayList<MoveLocation>();
		
		dormManagementDaoImpl.updatePeopleUnitLocation(peopleID, anotherLocationID);
		dormManagementDaoImpl.updatePeopleUnitLocation(anotherPeopleID, locationID);
		
		//更新异动信息表
		MoveLocation ml1 = new MoveLocation("宿舍互调", peopleID, locationID, anotherLocationID, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), 2);
		MoveLocation ml2 = new MoveLocation("宿舍互调", anotherPeopleID, anotherLocationID, locationID, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), 2);
		moveLocations.add(ml1);
		moveLocations.add(ml2);
		
		dormManagementDaoImpl.insertMoveLocation(moveLocations);
			
		result.put("msg", "调换成功");
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
