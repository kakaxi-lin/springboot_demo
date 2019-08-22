package com.yk.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.activemq.MQService;
import com.yk.po.User;
import com.yk.po.ValueDemo;
import com.yk.service.UserService;
import com.yk.websocket.WebSocketService;

@Controller
@RequestMapping("/first")
public class FirstController {
	@Resource
	UserService userService;
	
	@Resource
	MQService mqService;
	
	@Resource
	WebSocketService webSocketService;
	
	@Resource
	ValueDemo value;
	
	@RequestMapping("/first")
	public String first(HttpServletRequest request){
		System.out.println(value.getDesc());
		System.out.println(value.getIp());
		System.out.println(value.getName());
		request.setAttribute("kai", "凯哥好666");
		request.setAttribute("ctx", request.getServerName()+":"+request.getServerPort()+request.getContextPath());
		System.out.println(request.getServerName()+":"+request.getServerPort()+request.getContextPath());
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
	
	@RequestMapping("/websocket")
	public String websocket(HttpServletRequest request){
		return "websocket";
	}
	
	@RequestMapping("/validate")
	@ResponseBody
	public void validate(@Valid User user,Errors errors){
		List<ObjectError> errorList = errors.getAllErrors();
		for(ObjectError oe:errorList){
			System.out.println(oe.getDefaultMessage());
		}
		
	}
	
	@RequestMapping("/mq")
	@ResponseBody
	public void sendMsg(){
		String msg="解脱吧。。。";
		mqService.sendMsg(msg);
		
	}
	
	@RequestMapping("/sendWebsocketMsg")
	@ResponseBody
	public void sendWebsocketMsg(String message){
		webSocketService.sendMessages(message);
		
	}

}
