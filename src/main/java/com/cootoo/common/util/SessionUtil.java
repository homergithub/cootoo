package com.cootoo.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class SessionUtil {

	private SessionUtil(){
		
	}
	
	public static Session getSession(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		return session;
	}
}
