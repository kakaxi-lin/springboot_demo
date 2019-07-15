package com.yk.po;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ValueDemo {
	@Value("${yk.ip}")
	private String ip;
	@Value("${yk.name}")
	private String name;
	@Value("xxxdesc")
	private String desc;
	/*@PostConstruct
	public void run(){
		System.out.println("ip..."+ip);
		System.out.println("name..."+name);
		System.out.println("desc..."+desc);
	}*/
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
