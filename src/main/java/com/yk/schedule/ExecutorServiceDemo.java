package com.yk.schedule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
	static int num=0;
	public static void main(String[] args) {
		ScheduledExecutorService schedule=Executors.newScheduledThreadPool(1);
		schedule.scheduleAtFixedRate(new Runnable() {
		
			@Override
			public void run() {
				num++;
				System.out.println("运行一次。。。");
				System.out.println("当前线程名称。。。"+Thread.currentThread().getName());
				if(num==5){
					try {
						int a=3/0;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}, 0, 1, TimeUnit.SECONDS);
		System.out.println("异步。。。");
	}
	

}
