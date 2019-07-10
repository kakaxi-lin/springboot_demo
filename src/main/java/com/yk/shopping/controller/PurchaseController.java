package com.yk.shopping.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.shopping.po.Result;
import com.yk.shopping.service.PurchaseService;

@Controller
@RequestMapping("/shopping")
public class PurchaseController {
	@Resource
	PurchaseService purchaseService;
	
	@GetMapping("/purchase")
	@ResponseBody
	public Result purchase(int userId,int productId,int quantity){
		boolean success = purchaseService.purchase(userId, productId, quantity);
		String message=success?"抢购成功!":"抢购失败!";
		return new Result(success,message);
	}
	
	@GetMapping("/buy")
	public String buy(){
		return "shopping";
	}

}
