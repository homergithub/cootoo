package com.cootoo.systemmanagement.action;

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

import com.cootoo.menuManagement.service.MenuManagementService;
import com.cootoo.systemmanagement.domain.Login;
import com.cootoo.systemmanagement.domain.LoginRole;
import com.cootoo.systemmanagement.service.SystemManagementService;


@Controller
@RequestMapping(value="/systemManagement/")
public class SystemManagementAction {

	@Autowired
	private SystemManagementService systemManagementServiceImpl;
	@Autowired
	private MenuManagementService menuManagementServiceImpl;
	
	

	@RequestMapping(value="getUserRoleFunctions",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getUserRoleFunctions(HttpServletRequest request){
		
		
		Map<String,Object> result = new HashMap<String, Object>();
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		LoginRole role = (LoginRole) session.getAttribute("login");
	
		result.put("data", role);
		
		return result;
	
	}
	
	
	@RequestMapping(value="getAllRole",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAllRole(HttpServletRequest request){
		
		
		Map<String, Object> result = systemManagementServiceImpl.getAllRole();
		
		return result;
	}
		
		
	@RequestMapping(value="addLoginUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addLoginUser(HttpServletRequest request){
		
		
		String loginAccount = request.getParameter("loginAccount");
		String loginPassword = request.getParameter("loginPassword");
		Integer orgID = Integer.valueOf(request.getParameter("orgID"));
		Integer roleID = Integer.valueOf(request.getParameter("roleID"));
		
		Login login = new Login(loginAccount, loginPassword, orgID, roleID);
		Map<String, Object> result = systemManagementServiceImpl.addLoginUser(login);
	
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
