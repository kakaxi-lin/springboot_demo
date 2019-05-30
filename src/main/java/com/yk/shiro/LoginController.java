package com.yk.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/loginIn")
	public String loginIn(String username,String pwd){
		System.out.println("username..."+username);
		System.out.println("pwd..."+pwd);
		//组建Subject主体.
        Subject subject = SecurityUtils.getSubject();

        //创建 token 令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username,pwd);
        try {
			subject.login(token);
			System.out.println("验证成功");
			return "welcome";
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
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
	
	@RequestMapping("/visit")
	@ResponseBody
	@RequiresPermissions("user:delete")
	public String visit(){
		 Subject subject = SecurityUtils.getSubject();
		return "visit";
	}
}
