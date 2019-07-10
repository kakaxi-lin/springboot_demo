package com.yk.shopping.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yk.shopping.dao.ProductMapper;
import com.yk.shopping.dao.PurchaseRecordMapper;
import com.yk.shopping.po.Product;
import com.yk.shopping.po.PurchaseRecord;

@Service
public class PurchaseService {
	@Resource
	ProductMapper productMapper;
	
	@Resource
	PurchaseRecordMapper purchaseRecordMapper;
	
	public boolean purchase(int userId,int productId,int quantity){
		//查询产品的库存
		Product product = productMapper.selectByPrimaryKey(productId);
		if(product.getStock() < quantity){
			System.out.println("库存不足...");
			return false;
		}
		product.setStock(quantity);
		//减库存
		productMapper.decreaseProduct(product);
		PurchaseRecord purchaseRecord=new PurchaseRecord();
		purchaseRecord.setNote("购买时间："+System.currentTimeMillis());
		purchaseRecord.setPrice(product.getPrice());
		purchaseRecord.setProductId(product.getId());
		purchaseRecord.setQuantity(quantity);
		purchaseRecord.setUserId(userId);
		purchaseRecord.setPurchaseDate(new Date());
		purchaseRecord.setSum(product.getPrice()*quantity);
		//插入购买记录
		purchaseRecordMapper.insertSelective(purchaseRecord);
		return true;
		
	}

}
