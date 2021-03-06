package com.yk.shiro;

import java.io.Serializable;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/loginIn")
	public String loginIn(String username,String pwd,Boolean remember){
		System.out.println("username..."+username);
		System.out.println("pwd..."+pwd);
		System.out.println("remember..."+remember);
		//组建Subject主体
        Subject subject = SecurityUtils.getSubject();
        //创建 token 令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username,pwd);
        //设置自动登录
        token.setRememberMe(true);
        try {
			subject.login(token);
			System.out.println("验证成功");
			Session session = subject.getSession();
			Serializable id = session.getId();
			return "welcome";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("验证失败。。。");
			return null;
		}
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	@RequestMapping("/403")
	public String wrong(){
		return "403";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	@RequiresPermissions("user:delete")
	public String visit(){
		return "delete";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	@RequiresPermissions("user:update")
	public String update(){
		return "update";
	}
}
