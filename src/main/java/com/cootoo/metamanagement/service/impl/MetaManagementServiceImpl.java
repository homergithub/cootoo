package com.cootoo.metamanagement.service.impl;

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
import com.cootoo.common.imported.CardImporter;
import com.cootoo.common.imported.DepartmentImporter;
import com.cootoo.common.imported.ManagerCardImporter;
import com.cootoo.common.imported.ManagerCardToLocationImporter;
import com.cootoo.common.imported.PeopleImporter;
import com.cootoo.common.imported.UnitLocationImporter;
import com.cootoo.common.imported.UserToCardImporter;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.dao.MetaManagementDao;
import com.cootoo.metamanagement.domain.Card;
import com.cootoo.metamanagement.domain.CardType;
import com.cootoo.metamanagement.domain.Department;
import com.cootoo.metamanagement.domain.Location;
import com.cootoo.metamanagement.domain.Lock;
import com.cootoo.metamanagement.domain.ManagerCard;
import com.cootoo.metamanagement.domain.ManagerCardToLocation;
import com.cootoo.metamanagement.domain.Organization;
import com.cootoo.metamanagement.domain.People;
import com.cootoo.metamanagement.domain.Repeater;
import com.cootoo.metamanagement.domain.UnitLocation;
import com.cootoo.metamanagement.domain.UserToCard;
import com.cootoo.metamanagement.service.MetaManagementService;
@Service
public class MetaManagementServiceImpl implements MetaManagementService {

	private final Logger logger = Logger.getLogger(MetaManagementServiceImpl.class);
	
	@Autowired
	private MetaManagementDao metaManagementDaoImpl;
	
	@Override
	public Map<String, Object> getAllLocations(int orgID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Location> locations = metaManagementDaoImpl.getAllLocations(orgID);
		result.put("data", locations);
		return result;
	}

	@Override
	public Map<String, Object> addUnitLocation(UnitLocation unitLocation) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.insertUnitLocation(unitLocation);
		result.put("rows", rows);
		result.put("msg", "添加成功");
		return result;
	}

	@Override
	public Map<String, Object> removeUnitLocation(String[] locationID) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.deleteUnitLocation(locationID);
		result.put("rows", rows);
		result.put("msg", "删除成功");
		return result;
	}

	@Override
	public Map<String, Object> addRepeater(Repeater repeater) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.insertRepeater(repeater);
		result.put("rows", rows);
		result.put("msg", "添加成功");
		return result;
		
	}

	@Override
	public Map<String, Object> getAllRepeaters(int orgID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Location> repeaters = metaManagementDaoImpl.getAllRepeaters(orgID);
		result.put("data", repeaters);
		return result;	
		
	}

	@Override
	public Map<String, Object> getRepeater(String repeaterID,int orgID) {
		Map<String,Object> result = new HashMap<String, Object>();
		Repeater repeater = metaManagementDaoImpl.getRepeater(repeaterID,orgID);
		result.put("data", repeater);
		return result;	
	}

	@Override
	public Map<String, Object> updateRepeater(Repeater repeater) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.updateRepeater(repeater);
		result.put("rows", rows);
		result.put("msg", "更新成功");
		return result;
	}

	@Override
	public Map<String, Object> removeRepeater(String repeaterID) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.deleteRepeater(repeaterID);
		result.put("rows", rows);
		result.put("msg", "删除成功");
		return result;
	}

	@Override
	public Map<String, Object> addLock(Lock lock) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.insertLock(lock);
		result.put("rows", rows);
		result.put("msg", "添加成功");
		return result;
	}

	@Override
	public Map<String, Object> getCardType() {
		Map<String,Object> result = new HashMap<String, Object>();
		List<CardType> cardTypes = metaManagementDaoImpl.getCardType();
		result.put("data", cardTypes);
		return result;
		
	}

	@Override
	public Map<String, Object> addCard(Card card) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.insertCard(card);
		result.put("rows", rows);
		result.put("msg", "添加成功");
		return result;
	}

	@Override
	public Map<String, Object> getRepeaterByLocation(String locationID,int orgID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Location> repeaters = metaManagementDaoImpl.getRepeaterByLocation(locationID,orgID);
		result.put("data", repeaters);
		return result;
	}

	@Override
	public Map<String, Object> updateUnitLocation(UnitLocation unitLocation) {
		
//		Map<String,Object> result = new HashMap<String, Object>();
//		//父节点的treePath和parentNode
//		Map<String,Object> parentTreeAndNode = metaManagementDaoImpl.getUnitLocationTreePath(unitLocation.getParentNode(), unitLocation.getOrgID());
//		Map<String,Object> treeAndNode = metaManagementDaoImpl.getUnitLocationTreePath(unitLocation.getLocationID(), unitLocation.getOrgID());
//		
//		int rows = metaManagementDaoImpl.updateUnitLocation(unitLocation);
//		//获取parentnode
//		String parent = (String) treeAndNode.get("parentNode");
//		
//		if(!parent.equals(unitLocation.getParentNode())){
//			
//			//父节点的treePath和parentNode
//			//String parentNode = (String) parentTreeAndNode.get("parentNode");
//			String parentTreePath = (String) parentTreeAndNode.get("treePath");
//			
//			//当前节点的treePath和parentNode
//			String childTreePath = (String) treeAndNode.get("treePath");
//			
//			String tempTreePath = childTreePath.substring(0, childTreePath.lastIndexOf("/"));
//			
//			metaManagementDaoImpl.updateUnitLocationTreePath(tempTreePath,parentTreePath,unitLocation.getLocationID(), unitLocation.getOrgID());
//					
//			metaManagementDaoImpl.updateAllTreePath(tempTreePath,parentTreePath,childTreePath,unitLocation.getOrgID());
//			
//		}
//			
//		result.put("rows", rows);
//		result.put("msg", "修改成功");
//		return result;
		return null;
	}

	@Override
	public Map<String, Object> updateLock(Lock lock) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.updateLock(lock);
		result.put("rows", rows);
		result.put("msg", "修改成功");
		return result;
	}

	@Override
	public Map<String, Object> getUnitLocationByLocationID(String locationID,
			int orgID) {
		Map<String,Object> result = new HashMap<String, Object>();
		UnitLocation unitLocation = metaManagementDaoImpl.getUnitLocationByLocationID(locationID, orgID);
		result.put("data", unitLocation);
		return result;
	}

	@Override
	public Map<String, Object> getUnitLocationByLocationParent(
			String locationID, int orgID) {
		Map<String,Object> result = new HashMap<String, Object>();
		UnitLocation unitLocation = metaManagementDaoImpl.getUnitLocationByLocationParent(locationID, orgID);
		result.put("data", unitLocation);
		return result;
	}

	@Override
	public Map<String, Object> deleteLock(String lockMacID) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.deleteLock(lockMacID);
		result.put("rows", rows);
		result.put("msg", "删除成功");
		return result;
	}

	@Override
	public Map<String, Object> getAllCardByOrgID(int orgID, int cardTypeID,
			int cardName) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Card> cards = metaManagementDaoImpl.getAllCardByOrgID(orgID, cardTypeID, cardName);
		result.put("data",cards);
		return result;
	}

	@Override
	public Map<String, Object> updateCard(Card card) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.updateCard(card);
		result.put("rows", rows);
		result.put("msg", "更新成功");
		return result;
	}

	@Override
	public Map<String, Object> deleteCard(String cardMacID) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.deleteCard(cardMacID);
		result.put("rows", rows);
		result.put("msg", "删除成功");
		return result;
	}

	@Override
	public Map<String, Object> getAllLock(int orgID) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Location> locks = metaManagementDaoImpl.getAllLock(orgID);
		result.put("data", locks);
		return result;
	}

	@Override
	public Map<String, Object> getLock(String lockMacID, int orgID) {
		Map<String,Object> result = new HashMap<String, Object>();
		Lock lock = metaManagementDaoImpl.getLock(lockMacID, orgID);
		result.put("data", lock);
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
					metaManagementDaoImpl.deletePeople(list);
					count += metaManagementDaoImpl.insertPeople(list);
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
	public Map<String, Object> allocateCard(String peopleID, String cardMacID) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.insertPeopleToCard(peopleID, cardMacID);
		result.put("rows", rows);
		result.put("msg", "分配成功");
		return result;
	}

	@Override
	public Map<String, Object> addUnitLocation(MultipartFile file,int orgID) {
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
					metaManagementDaoImpl.deleteUnitLocationList(list);
					count += metaManagementDaoImpl.insertUnitLocationList(list);
					int treePathNum = metaManagementDaoImpl.getTreePathByOrgID(orgID);
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
	public Map<String, Object> addCard(MultipartFile file) {
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		long count = 0l;
		
		if(file!=null){
			// 获得文件名：   
	        String fileName = file.getOriginalFilename();  
			Workbook workBook = null;
		       	
			try {
				
				workBook = ExcelUtil.buildWorkbook(file, fileName);
				ExcelUtil<Card> eu = new CardImporter();
				List<List<Card>> content = eu.readExcel(workBook);
				for (List<Card> list : content) {
					metaManagementDaoImpl.deleteCards(list);
					count += metaManagementDaoImpl.insertCardList(list);
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
					metaManagementDaoImpl.deleteDepartments(list);
					count += metaManagementDaoImpl.insertDepartment(list);
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
	public Map<String, Object> addUserToCard(MultipartFile file) {
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		long count = 0l;
		
		if(file!=null){
			// 获得文件名：   
	        String fileName = file.getOriginalFilename();  
			Workbook workBook = null;
		       	
			try {
				
				workBook = ExcelUtil.buildWorkbook(file, fileName);
				ExcelUtil<UserToCard> eu = new UserToCardImporter();
				List<List<UserToCard>> content = eu.readExcel(workBook);
				for (List<UserToCard> list : content) {
					//重复删除操作
					for (UserToCard userToCard : list) {
						metaManagementDaoImpl.deleteUserToCard(userToCard);
					}
					//导入数据
					count += metaManagementDaoImpl.insertUserToCard(list);
					
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
	public Map<String, Object> addOrgnization(Organization org) {
		Map<String,Object> result = new HashMap<String, Object>();
		int rows = metaManagementDaoImpl.insertOrganization(org);
		result.put("rows", rows);
		result.put("msg", "添加成功");
		return result;
	}

	@Override
	public Map<String, Object> addManagerCard(MultipartFile file) {
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		long count = 0l;
		
		if(file!=null){
			// 获得文件名：   
	        String fileName = file.getOriginalFilename();  
			Workbook workBook = null;
		       	
			try {
				
				workBook = ExcelUtil.buildWorkbook(file, fileName);
				ExcelUtil<ManagerCard> eu = new ManagerCardImporter();
				List<List<ManagerCard>> content = eu.readExcel(workBook);
				for (List<ManagerCard> list : content) {
					//重复删除操作
					metaManagementDaoImpl.deleteManagerCard(list);
					//导入数据
					count += metaManagementDaoImpl.insertManagerCard(list);
					
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
	public Map<String, Object> addManagerCardToLocation(MultipartFile file) {
		Map<String,Object> result = new HashMap<String, Object>();
		String msg = "";
		long count = 0l;
		
		if(file!=null){
			// 获得文件名：   
	        String fileName = file.getOriginalFilename();  
			Workbook workBook = null;
		       	
			try {
				
				workBook = ExcelUtil.buildWorkbook(file, fileName);
				ExcelUtil<ManagerCardToLocation> eu = new ManagerCardToLocationImporter();
				List<List<ManagerCardToLocation>> content = eu.readExcel(workBook);
				for (List<ManagerCardToLocation> list : content) {
					//重复删除操作
					for (ManagerCardToLocation managerCardToLocation : list) {
						metaManagementDaoImpl.deleteManagerCardToLocation(managerCardToLocation);
					}
					//导入数据
					count += metaManagementDaoImpl.insertManagerCardToLocation(list);
					
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


}
