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

import com.cootoo.common.imported.CardImporter;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.dao.CardManagementDao;
import com.cootoo.metamanagement.domain.Card;
import com.cootoo.metamanagement.domain.CardType;
import com.cootoo.metamanagement.service.CardManagementService;

@Service
public class CardManagementServiceImpl implements CardManagementService {
	
	private final Logger logger = Logger.getLogger(CardManagementServiceImpl.class);

	@Autowired
	private CardManagementDao cardManagementDaoImpl;
	
	private final String INSERT_SUCCESS="添加门卡成功!";
	
	private final String MODIFY_SUCCESS="修改门卡成功!";

	@Override
	public Map<String, Object> addCard(List<Card> cardList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		cardManagementDaoImpl.insertCard(cardList);
		result.put("msg", INSERT_SUCCESS);
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
					
					List<String> cardIDList = new ArrayList<String>();
					//获取所有卡号，删除
					for (Card card : list) {
						cardIDList.add(card.getCardMacID());
					}
					
					cardManagementDaoImpl.deleteCard(cardIDList);
					count += cardManagementDaoImpl.insertCard(list);
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
	public Map<String, Object> deleteCard(List<String> cardIDList) {
		Map<String,Object> result = new HashMap<String, Object>();		
		int rows = cardManagementDaoImpl.deleteCard(cardIDList);
		result.put("msg", getDeleteMsg(rows));
		return result; 
	}

	@Override
	public Map<String, Object> modifyCard(Card card) {
		Map<String,Object> result = new HashMap<String, Object>();		
		cardManagementDaoImpl.updateCard(card);
		result.put("msg", MODIFY_SUCCESS);
		return result; 
	}
	

	@Override
	public Map<String, Object> getCardType() {
		Map<String,Object> result = new HashMap<String, Object>();		
		List<CardType> cardTypes = cardManagementDaoImpl.selectCardType();
		result.put("data", cardTypes);
		return result; 
	}
	
	
	private final String getDeleteMsg(int rows){
		return "删除" + rows + "条门卡信息";
	}

	
}
