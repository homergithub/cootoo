/*Copyright (c) 2015, cootoo and/or its affiliates. All rights reserved.*/
package com.cootoo.menuManagement.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cootoo.menuManagement.domain.Menu;
import com.cootoo.menuManagement.service.MenuManagementService;
/**
 * @description 菜单管理模块控制层 
 * @author Homer
 * @version 1.0
 * @date 2015-05-25
 */
@Controller
@RequestMapping(value="/menuManagement/")
public class MenuManagementAction {

	@Autowired
	private MenuManagementService menuManagementServiceImpl;
	
	
	@Deprecated
	@RequestMapping(value="getModules",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getModules(){
		return menuManagementServiceImpl.getModules();
	}
	
	
	
	@Deprecated
	@RequestMapping(value="getFunctions",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFunctions(HttpServletRequest request) {
		int moduleID = Integer.parseInt(request.getParameter("moduleID"));
		return menuManagementServiceImpl.getFunctions(moduleID);
	}
	
	
	/**
	 * 获取所有菜单资源（有权限控制）
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getMenus",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMenus(HttpServletRequest request){
		
		Map<String,Object> result = new HashMap<String, Object>();
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		Menu menu = (Menu) session.getAttribute("menu");
		
		result.put("data", menu);
		
		return result;
		//return menuManagementServiceImpl.getMenus();
	}
	
	
	
	
	
}
