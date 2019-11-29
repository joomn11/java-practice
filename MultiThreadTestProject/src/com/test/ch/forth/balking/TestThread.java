package com.test.ch.forth.balking;

public class TestThread extends Thread{
	
	@Override
	public void run() {
		
		System.out.print("BEGIN");
		for (int i=0; i<50; i++) {
			System.out.print(".");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print("END");
	}
}
