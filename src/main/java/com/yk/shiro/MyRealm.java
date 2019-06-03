package com.yk.shiro;

import java.util.HashSet;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
public class MyRealm extends AuthorizingRealm{
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("授权。。。");
		SimpleAuthorizationInfo a =new SimpleAuthorizationInfo();
		Set<String> set=getPerms();
		a.addStringPermissions(set);
		String name=(String) principals.getPrimaryPrincipal();
		System.out.println("授权name..."+name);
		return a;
	}
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String name=(String) token.getPrincipal();
		String pwd=getPwd();
		System.out.println("name..."+name);
		System.out.println("认证。。。");
		if(name.equals("k")){
			SimpleAuthenticationInfo s=new SimpleAuthenticationInfo (name,pwd,getName());
			return s;		
		}else{
			return null;
		}
	}
	
	public static String getPwd(){
		System.out.println("获取密码...");
		return "1";
	}
	
	public static Set<String> getPerms(){
		System.out.println("获取权限...");
		Set<String> set =new HashSet<String>();
		set.add("user:delete");
		set.add("user:add");
		return set;
	}


}
