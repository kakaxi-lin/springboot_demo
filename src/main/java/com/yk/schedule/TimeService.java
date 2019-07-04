package com.yk.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling  //开启定时任务
@EnableAsync    //开启多线程
public class TimeService {
	@Scheduled(fixedRate=3000)
	@Async("asyncServiceExecutor")
	public void print(){
		System.out.println("都是垃圾。。。");
		System.out.println(Thread.currentThread().getName());
		System.out.println("---------------------");
	}

}
