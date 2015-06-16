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

import com.cootoo.common.imported.ManagerCardImporter;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.dao.MgrCardManagementDao;
import com.cootoo.metamanagement.domain.ManagerCard;
import com.cootoo.metamanagement.service.MgrCardManagementService;

@Service
public class MgrCardManagementServiceImpl implements MgrCardManagementService {

	private final Logger logger = Logger.getLogger(MgrCardManagementServiceImpl.class);
	
	@Autowired
	private MgrCardManagementDao mgrCardManagementDaoImpl;
	
	private final String INSERT_SUCCESS="添加管理卡成功!";
	
	private final String MODIFY_SUCCESS="修改管理卡成功!";

	
	@Override
	public Map<String, Object> addMgrCard(List<ManagerCard> mgrCardList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		mgrCardManagementDaoImpl.insertMgrCard(mgrCardList);
		result.put("msg", INSERT_SUCCESS);
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
					List<String> mgrCardIDList = new ArrayList<String>();
					for (ManagerCard mgrCard : list) {
						mgrCardIDList.add(mgrCard.getManagerCardID());
					}
					mgrCardManagementDaoImpl.deleteMgrCard(mgrCardIDList);
					//导入数据
					count += mgrCardManagementDaoImpl.insertMgrCard(list);
					
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
	public Map<String, Object> deleteMgrCard(List<String> mgrCardIDList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		int rows = mgrCardManagementDaoImpl.deleteMgrCard(mgrCardIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}

	@Override
	public Map<String, Object> modifyMgrCard(ManagerCard mgrCard) {
		Map<String,Object> result = new HashMap<String, Object>();		
		mgrCardManagementDaoImpl.updateMgrCard(mgrCard);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}

	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条管理卡信息";
	}

	
	
}
