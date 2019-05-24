package com.yk.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@RequestMapping("/login")
	@ResponseBody
	public void login(String username,String pwd){
		System.out.println("username..."+username);
		System.out.println("pwd..."+pwd);
		//初始化SecurityManager对象
				Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

		        //通过SecurityManager工厂对象,获取SecurityManager实例对象.
		        SecurityManager securityManager =  factory.getInstance();

		        // 把 securityManager 实例 绑定到 SecurityUtils
		        SecurityUtils.setSecurityManager(securityManager);
		//组建Subject主体.
        Subject subject = SecurityUtils.getSubject();

        //创建 token 令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username,pwd);
        try {
			subject.login(token);
			System.out.println("验证成功");
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("验证失败。。。");
		}
	}
	
	@RequestMapping("/login1")
	@ResponseBody
	public void login1(String username,String pwd){
		System.out.println("xxxxxx");
	}
}
