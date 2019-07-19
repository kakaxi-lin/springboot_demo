package com.yk.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class TimerServiceDemo {
	static int num=0;
	public static void main(String[] args) {
		Timer timer=new Timer();
		System.out.println("第一次执行延迟三秒");
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				num++;
				System.out.println("一秒一次");
				if(num==5){
					System.out.println("第五次结束定时任务");
					timer.cancel();
				}
				
			}
		}, 3000, 1000);
	}

}
