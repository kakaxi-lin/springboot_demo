package com.yk.test;


public class TestTime {
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++){
					try {
						Thread.sleep(1000);
						System.out.println("22222");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		System.out.println("34444444444");
	}

}
