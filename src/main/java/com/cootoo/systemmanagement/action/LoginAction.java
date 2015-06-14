package com.cootoo.systemmanagement.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAction {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/logon/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request){
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		
		String loginAccount = request.getParameter("userAccount");
		String loginPassword = request.getParameter("userPassword");
	
		
		UsernamePasswordToken token = new UsernamePasswordToken(loginAccount, loginPassword);
		
		Subject currentUser = SecurityUtils.getSubject();
		try{
			currentUser.login(token);					
			String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/home.html"; 
			result.put("code", "1");
			result.put("msg", "登录成功");
			result.put("url", url);		
			
		} catch (UnknownAccountException uae ) {
			logger.error("账号错误", uae);
	    } catch (IncorrectCredentialsException ice ) {
	    	logger.error("密码错误", ice);
	    } catch (LockedAccountException lae ) {
	    	logger.error("账号被锁", lae);
	    } catch (AuthenticationException ae) {
	    	logger.error("用户名或密码错误", ae);
	    	result.put("msg", "用户名或密码错误");
			token.clear();
	    }
				
		return result;	
		
	}
}
