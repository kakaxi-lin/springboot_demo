package com.yk.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.po.User;
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
	
	@RequestMapping("/validate")
	@ResponseBody
	public void validate(@Valid User user,Errors errors){
		List<ObjectError> errorList = errors.getAllErrors();
		for(ObjectError oe:errorList){
			System.out.println(oe.getDefaultMessage());
		}
		
	}

}
