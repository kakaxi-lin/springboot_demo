package com.yk.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
public class MyRealm extends AuthorizingRealm{
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("授权。。。");
		return null;
	}
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String name=(String) token.getPrincipal();
		String pwd=null;
		System.out.println("name..."+name);
		System.out.println("认证。。。");
		if(name.equals("root")){
			pwd="123456";
			SimpleAuthenticationInfo s=new SimpleAuthenticationInfo (name,pwd,"xx");
			return s;		
		}else{
			return null;
		}
	}


}
