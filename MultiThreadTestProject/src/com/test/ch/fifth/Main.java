package com.test.ch.fifth;

public class Main {
	
	public static void main(String[] args) {
		Table table = new Table(3);
		
		Thread[] arr = {
				new MakerThread("MakerThread-1", table, 321456),
				new MakerThread("MakerThread-2", table, 921456),
				new MakerThread("MakerThread-3", table, 510456),
				
				new EaterThread("EaterThread-1", table, 315867),
				new EaterThread("EaterThread-2", table, 612867),
				new EaterThread("EaterThread-3", table, 395867)
				
		};
		
		for(Thread thread : arr) {
			thread.start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----interrupted------");
		
		for(Thread thread : arr) {
			thread.interrupt();
		}
		
//		new ClearThread("ClearThrad-0", table).start();
	}
}
