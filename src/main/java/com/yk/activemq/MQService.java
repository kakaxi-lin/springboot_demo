package com.yk.activemq;

import javax.annotation.Resource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
@Service
public class MQService {
	@Resource
	private JmsTemplate jmsTemplate;
	//发送消息
	public void sendMsg(String msg){
		System.out.println("发送的消息。。。"+msg);
		jmsTemplate.convertAndSend("kai-des", msg);
	}
	//接收消息
	@JmsListener(destination="kai-des")
	public void receiveMsg(String msg){
		System.out.println("接收的消息。。。。。。。。。。。。。"+msg);
	}
	
}
