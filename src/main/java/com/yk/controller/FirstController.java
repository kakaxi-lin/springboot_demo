package com.yk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yk.service.UserService;

@Controller
@RequestMapping("/first")
public class FirstController {
	@Resource
	UserService userService;
	@RequestMapping("/first")
	public String first(HttpServletRequest request){
		System.out.println("cccccccc");
		request.setAttribute("kai", "凯哥好666");
//		userService.selectUserById();		
		try {
			userService.selectByPage();
//			userService.insertUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "first";
	}

}
