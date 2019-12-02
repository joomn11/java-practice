package com.test.ch.fifth;

public class Host {
	
	public static void execute(int count) throws InterruptedException {
		for(int i=0; i<count; i++) {
			doHeavyJob();
		}
	}
	
	private static void doHeavyJob() throws InterruptedException {
		System.out.println("doHeavyJob BEGIN");
		
		long start = System.currentTimeMillis();
		while(start + 10000 > System.currentTimeMillis()) {
			// busy loop
			if(Thread.interrupted()){
				throw new InterruptedException();
			}
			
		}
		
		System.out.println("doHeavyJob END");
	}
}
