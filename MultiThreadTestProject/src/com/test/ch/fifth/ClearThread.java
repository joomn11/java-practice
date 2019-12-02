package com.test.ch.fifth;

public class ClearThread extends Thread{
	private final Table table;
	
	public ClearThread(String name, Table table) {
		super(name);
		this.table = table;
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				sleep(1000);
				System.out.println(Thread.currentThread().getName() + " clear");
				table.clear();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
