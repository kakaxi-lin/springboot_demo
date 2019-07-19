package com.yk.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService {
	static int num=0;
	public static void main(String[] args) {
		Timer timer=new Timer();
//		schedule 按照上次结束的时间进行计算
//		timer.schedule(task, time);
		System.out.println("第一次执行延迟三秒");
//		scheduleAtFixedRate 按照上次开始的时间进行计算
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
