package com.cootoo.systemmanagement.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.cootoo.systemmanagement.dao.SystemManagementDao;
import com.cootoo.systemmanagement.domain.Login;
import com.cootoo.systemmanagement.domain.LoginRole;

public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private SystemManagementDao systemManagementDaoImpl;	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
//		String loginName = (String) principals.fromRealm(getName()).iterator().next();
//		
//		if(loginName.equals("zhuhong")){
//			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
//			info.addRole("admin");
//			return info;
//		}		
		
		return null;
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
	    
		String loginAccount = token.getUsername();
		String loginPassword = String.valueOf(token.getPassword());
		
		Login login = systemManagementDaoImpl.selectLoginUser(loginAccount, loginPassword);
		
		
		if(login!=null){
			LoginRole loginRole = systemManagementDaoImpl.selectRoleFunctions(login.getLoginID());
			Subject currentUser = SecurityUtils.getSubject();
			Session session = currentUser.getSession();
			session.setAttribute("login", loginRole);
			return new SimpleAuthenticationInfo(login.getLoginAccount(),login.getLoginPassword(),getName());
		}else{
			throw new AuthenticationException("账户或密码错误");
		}
		
		
	}

}
