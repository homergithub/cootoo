/*Copyright (c) 2015, cootoo and/or its affiliates. All rights reserved.*/
package com.cootoo.metamanagement.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cootoo.common.util.DownLoadUtil;
import com.cootoo.metamanagement.domain.Organization;
import com.cootoo.metamanagement.service.MetaManagementService;
/**
 * @description 元数据管理模块控制层 
 * @author Homer
 * @version 1.0
 * @date 2015-05-25
 */
@Controller
@RequestMapping(value="/metaManagement/")
public class MetaManagementAction {

	private final Logger logger = Logger.getLogger(MetaManagementAction.class);
	
	@Autowired
	private MetaManagementService metaManagementServiceImpl;
	
	/**
	 * 通过单位编号得到所有建筑单元
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getAllLocations",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAllLocations(HttpServletRequest request){
		
		//此处从session中获得登陆着所在单位的orgID
	
		
		
		
		Map<String, Object> result =  metaManagementServiceImpl.getAllLocations(1);
		return result;
	}
	
	/**
	 * 通过建筑单元编号得到建筑单元信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getUnitLocationByLocationID",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getUnitLocationByLocationID(HttpServletRequest request){
		
		//此处从session中获得登陆着所在单位的orgID
		
		
		String locationID = request.getParameter("locationID");
		Map<String, Object> result = metaManagementServiceImpl.getUnitLocationByLocationID(locationID, 1);
		return result;
		
	}
	
	/**
	 * 获取建筑单元根节点信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getUnitLocationByLocationParent",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getUnitLocationByLocationParent(HttpServletRequest request){
		
		//此处从session中获得登陆着所在单位的orgID
		
		
	    String locationID = request.getParameter("locationID");
	    Map<String, Object> result = metaManagementServiceImpl.getUnitLocationByLocationParent(locationID, 1);
	    return result;
	}
	
	/**
	 * 添加建筑单元信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="addUnitLocation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addUnitLocation(HttpServletRequest request){
		
//		String locationID = request.getParameter("locationID");
//		String unitName = request.getParameter("unitName");
//		String parentNode = request.getParameter("parentID").trim();
//		
//		String unitType = request.getParameter("unitType");
//		Integer people = null;
//		String strPeople = request.getParameter("People").trim();
//		if(!"".equals(strPeople)){
//			people = Integer.parseInt(strPeople);
//		}
//		
//		String sex = request.getParameter("sex");
//		if("-1".equals(sex)){
//			sex = null;
//		}
		
		//此处应该有获取登陆者所在单位的orgID,暂时先都把orgID全部设为1
		
		
		
		
		
		//UnitLocation unitLocation = new UnitLocation(locationID ,unitName, parentNode , unitType, 1, people, sex);
		
		//Map<String, Object> result =  metaManagementServiceImpl.addUnitLocation(unitLocation);
		//return result;
		return null;
	}
	
	/**
	 * 删除建筑单元
	 * @param request
	 * @return
	 */
	@RequestMapping(value="removeUnitLocation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> removeUnitLocation(HttpServletRequest request){
		
		String locationIDArray = request.getParameter("locationID");
		//String[] locationIDStrArray = request.getParameterValues("locationID");
		String[] locationIDStrArray = locationIDArray.split(",");
		
		
		Map<String, Object> result = metaManagementServiceImpl.removeUnitLocation(locationIDStrArray);
		return result;
		
	}
	
	/**
	 * 更新建筑单元
	 * @param request
	 * @return
	 */
	@RequestMapping(value="updateUnitLocation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateUnitLocation(HttpServletRequest request){
		
//		String locationID = request.getParameter("locationID");
//		String unitName = request.getParameter("unitName");
//		String parentNode = request.getParameter("parentID");
//		String unitType = request.getParameter("unitType");
//		String people = request.getParameter("unitSize");
//		Integer unitSize = null;
//		if(null != people && !"".equals(people)){
//			unitSize = Integer.parseInt(people);
//		}
//		
//		String sex = request.getParameter("sex");
		
		//此处获取orgID
		
		//UnitLocation unitLocation = new UnitLocation(locationID, unitName, parentNode, unitType, 1, unitSize, sex);
		
		//Map<String, Object> result = metaManagementServiceImpl.updateUnitLocation(unitLocation);
		//return result;
		return null;
	}
	
	
	
	/**
	 * 添加中继器
	 * @param request
	 * @return
	 */
//	@RequestMapping(value="addRepeater",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> addRepeater(HttpServletRequest request){
//		
//		String repeaterID = request.getParameter("repeaterID");
//		String repeaterName = request.getParameter("repeaterName");
//		String repeaterIP = request.getParameter("repeaterIP");
//		String locationID =  request.getParameter("locationID");
//		
//		Repeater repeater = new Repeater(repeaterID, repeaterName, repeaterIP, locationID);
//		Map<String, Object> result = metaManagementServiceImpl.addRepeater(repeater); 
//		return result;
//		
//	}
	
	/**
	 * 通过单位编号获取所有中继器
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getAllRepeaters",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAllRepeaters(HttpServletRequest request){
		
		//此处获取session中的orgID,暂时用1
		
		Map<String, Object> result = metaManagementServiceImpl.getAllRepeaters(1);
		
		return result;
	}
	
	/**
	 * 通过中继器编号获取中继器信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getRepeater",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getRepeater(HttpServletRequest request){
		
		//此处获取orgID
		
		String repeaterID = request.getParameter("repeaterID");
		
		Map<String, Object> repeater = metaManagementServiceImpl.getRepeater(repeaterID,1);
		
		return repeater;
	}
	
	/**
	 * 通过地址编号得到中继器
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getRepeaterByLocation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getRepeaterByLocation(HttpServletRequest request){
		//此处获取orgID
		
		
		String locationID = request.getParameter("locationID");
		return metaManagementServiceImpl.getRepeaterByLocation(locationID,1);
	}
	
	
	
	/**
	 * 更新中继器
	 * @param request
	 * @return
	 */
//	@RequestMapping(value="updateRepeater",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> updateRepeater(HttpServletRequest request){
//		
//		String repeaterID = request.getParameter("repeaterID");
//		String repeaterName = request.getParameter("repeaterName");
//		String repeaterIP = request.getParameter("repeaterIP");
//		String locationID = request.getParameter("locationID");
//		Repeater repeater = new Repeater(repeaterID, repeaterName, repeaterIP,locationID);
//
//		Map<String, Object> result = metaManagementServiceImpl.updateRepeater(repeater);
//		
//		return result;
//	}
	
	/**
	 * 删除中继器
	 * @param request
	 * @return
	 */
	@RequestMapping(value="removeRepeater",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> removeRepeater(HttpServletRequest request){
		
		String repeaterID = request.getParameter("repeaterID");
		Map<String, Object> result = metaManagementServiceImpl.removeRepeater(repeaterID);	
		return result;
	}
	
	/**
	 * 通过单位编号获取所有锁
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getAllLock",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAllLock(HttpServletRequest request){
		
		//此处获取orgID
		
		
		Map<String, Object> result = metaManagementServiceImpl.getAllLock(1);
		return result;
	}
	
	/**
	 * 获取锁信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getLock",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getLock(HttpServletRequest request){
		
		String lockMacID = request.getParameter("lockMacID");
		
		//此处获取orgID
		
		
		
		Map<String, Object> result = metaManagementServiceImpl.getLock(lockMacID, 1);
		return result;
	}
	
	/**
	 * 添加锁
	 * @param request
	 * @return
	 */
//	@RequestMapping(value="addLock",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> addLock(HttpServletRequest request){
//		
//		String lockMacID = request.getParameter("lockMacID");
//		String lockName = request.getParameter("lockName");
//		String locationID = request.getParameter("locationID");
//		String isLive = request.getParameter("isLive");
//		String repeaterID = request.getParameter("repeaterID");
//		String time = DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss");
//		//Lock lock = new Lock(lockMacID,lockName,locationID,isLive,repeaterID,time);
//		
//		//Map<String, Object> result = metaManagementServiceImpl.addLock(lock);
//		return null;
//	}
//	
	/**
	 * 更新锁
	 * @param request
	 * @return
	 */
//	@RequestMapping(value="updateLock",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> updateLock(HttpServletRequest request){
//		
//		String lockMacID = request.getParameter("lockMacID");
//		String lockName = request.getParameter("lockName");
//		String locationID = request.getParameter("locationID");
//		String isLive = request.getParameter("isLive");
//		String repeaterID = request.getParameter("repeaterID");
//		String updateTime = DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss");
//		
//		//Lock lock = new Lock(lockMacID, lockName, locationID, isLive, repeaterID, updateTime);
//		//Map<String, Object> result = metaManagementServiceImpl.updateLock(lock);
//		
//		return null;
//		
//		
//	}
	
	/**
	 * 删除锁
	 * @param request
	 * @return
	 */
	@RequestMapping(value="deleteLock",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteLock(HttpServletRequest request){
		
		String lockMacID = request.getParameter("lockMacID");
		Map<String, Object> result = metaManagementServiceImpl.deleteLock(lockMacID);
		return result;
	}
	
	/**
	 * 获取门卡类型
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getCardType",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getCardType(HttpServletRequest request){
		
		Map<String, Object> result = metaManagementServiceImpl.getCardType();
		return result;
	}
	
	/**
	 * 添加门卡
	 * @param request
	 * @return
	 */
//	@RequestMapping(value="addCard",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> addCard(HttpServletRequest request){
//		
//		String cardMacID = request.getParameter("cardMacID");
//		String cardNameStr = request.getParameter("cardName");
//		Integer cardName = null;
//		if(null != cardNameStr){
//			cardName = Integer.parseInt(cardNameStr);
//		}
//
//		String cardIsLive = request.getParameter("cardIsLive");
//		String cardTypeIDStr = request.getParameter("cardTypeID");
//		Integer cardTypeID = null;
//		if(null != cardTypeIDStr){
//			cardTypeID = Integer.parseInt(cardTypeIDStr);
//		}
//				
//		
//		String cardRegisterTime = DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss");
//		//此处获取orgID
//		
//		Card card = new Card(cardMacID,cardName,cardIsLive,cardRegisterTime,cardTypeID,1);
//		Map<String, Object> result = metaManagementServiceImpl.addCard(card);
//		return result;
//		
//	}
//	
	
	/**
	 * 通过单位编号获取所有门卡
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getAllCardByOrgID",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getAllCardByOrgID(HttpServletRequest request){
		
		String cardTypeIDStr = request.getParameter("cardTypeID");
		Integer cardTypeID = -1;
		if(null != cardTypeIDStr && !"".equals(cardTypeIDStr) && !"0".equals(cardTypeIDStr)){
			cardTypeID = Integer.parseInt(cardTypeIDStr);
		}
		String cardNameStr = request.getParameter("cardName");
		Integer cardName = -1;
		if(null != cardNameStr && !"".equals(cardNameStr)){
			cardName = Integer.parseInt(cardNameStr);
		}
		
		//此处要获取orgID
		
		
		Map<String, Object> result = metaManagementServiceImpl.getAllCardByOrgID(1, cardTypeID, cardName);
		return result;
	}
	
	/**
	 * 更新门卡
	 * @param request
	 * @return
	 */
//	@RequestMapping(value="updateCard",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> updateCard(HttpServletRequest request){
//		
//		String cardMacID = request.getParameter("cardMacID");
//		String cardNameStr = request.getParameter("cardName");
//		Integer cardName = null;
//		if(null != cardNameStr){
//			cardName = Integer.parseInt(cardNameStr);
//		}
//		String cardIsLive = request.getParameter("cardIsLive");
//		String cardTypeIDStr = request.getParameter("cardTypeID");
//		Integer cardTypeID = null;
//		if(null != cardTypeIDStr){
//			cardTypeID = Integer.parseInt(cardTypeIDStr);
//		}
//		
//		Card card = new Card(cardMacID, cardName, cardIsLive, cardTypeID);
//		Map<String, Object> result = metaManagementServiceImpl.updateCard(card);
//		return result;
//	}
	
	
	/**
	 * 删除门卡
	 * @param request
	 * @return
	 */
	@RequestMapping(value="deleteCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteCard(HttpServletRequest request){
		
		String cardMacID = request.getParameter("cardMacID");
		Map<String, Object> result = metaManagementServiceImpl.deleteCard(cardMacID);
		return result;
	}
	
	
	/**
	 * 文件下载模版
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="downloadModel",method=RequestMethod.GET)
	public void downloadPeopleModel(HttpServletRequest request,HttpServletResponse response){
		
		
		
		//String downloadFileName = "people.xlsx";
		String downloadFileName = request.getParameter("fileName");
		String fileName = request.getSession().getServletContext().getRealPath("/") + "download/" + downloadFileName;
	         
	    long fileLength = new File(fileName).length();   
	     
	    try {
	    	downloadFileName = new String(downloadFileName.getBytes("utf-8"), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}
	    response.setContentType("application/x-msdownload;");   
	    response.setHeader("Content-disposition", "attachment; filename=" + downloadFileName);   
	    response.setHeader("Content-Length", String.valueOf(fileLength));
	    
	    try {
			DownLoadUtil.downloadFile(response.getOutputStream(), fileName);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
	}
		
	
	/**
	 * 住户信息导入
	 * @param request
	 * @return
	 */
	@RequestMapping(value="peopleImport",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> peopleImport(HttpServletRequest request){

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
	
		Map<String, Object> result = metaManagementServiceImpl.addPeople(file);
	
		return result;

	 }
	
	/**
	 * 建筑单元信息导入
	 * @param request
	 * @return
	 */
	@RequestMapping(value="unitLocationImport",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> unitLocationImport(HttpServletRequest request){
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		//获取登陆着orgID
		
		
		Map<String, Object> result = metaManagementServiceImpl.addUnitLocation(file,1);
		return result;
	}
	
	/**
	 * 门卡的分配
	 * @param request
	 * @return
	 */
	@RequestMapping(value="allocateCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> allocateCard(HttpServletRequest request){
		
		String peopleID = request.getParameter("peopleID");
		String cardMacID = request.getParameter("cardMacID");
		
		Map<String, Object> result = metaManagementServiceImpl.allocateCard(peopleID, cardMacID);
		return result;
		
	}
	
	/**
	 * 门卡信息导入
	 * @param request
	 * @return
	 */
	@RequestMapping(value="cardImport",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> cardImport(HttpServletRequest request){

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
	
		Map<String, Object> result = metaManagementServiceImpl.addCard(file);
	
		return result;

	 }
	
	/**
	 * 部门信息导入
	 * @param request
	 * @return
	 */
	@RequestMapping(value="departImport",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> departImport(HttpServletRequest request){

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
	
		Map<String, Object> result = metaManagementServiceImpl.addDepartment(file);
	
		return result;

	 }
	
	/**
	 * 住户－门卡信息导入
	 * @param request
	 * @return
	 */
	@RequestMapping(value="userCardImport",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> userCardImport(HttpServletRequest request){

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
	
		Map<String, Object> result = metaManagementServiceImpl.addUserToCard(file);
	
		return result;

	 }
	
	
	/**
	 * 添加项目单位
	 * @param request
	 * @return
	 */
	@RequestMapping(value="addOrgnization",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addOrgnization(HttpServletRequest request){
		
		String orgID = request.getParameter("orgID");
		String orgName = request.getParameter("orgName");
		Organization orgnization = new Organization(orgID, orgName);
		Map<String, Object> result = metaManagementServiceImpl.addOrgnization(orgnization);
		return result;
	}
	
	/**
	 * 导入管理卡
	 * @param request
	 * @return
	 */
	@RequestMapping(value="addManagerCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addManagerCard(HttpServletRequest request){
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file2");
	
		Map<String, Object> result = metaManagementServiceImpl.addManagerCard(file);
	
		return result;
		
		
	}
	
	/**
	 * 导入管理卡－管理区域
	 * @param request
	 * @return
	 */
	@RequestMapping(value="addManagerCardToLocation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addManagerCardToLocation(HttpServletRequest request){
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
	
		Map<String, Object> result = metaManagementServiceImpl.addManagerCardToLocation(file);
	
		return result;
		
		
	}
	
	
	
	
	
}
