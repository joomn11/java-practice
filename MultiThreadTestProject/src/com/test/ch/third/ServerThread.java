package com.test.ch.third;

import java.util.Random;

public class ServerThread extends Thread{

	private Random random;
	private RequestQueue requestQueue;
	
	public ServerThread(RequestQueue requestQueue, String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}
	

	@Override
	public void run() {
		for(int i = 0; i<10000; i++) {
			Request request = new Request("No. " +1);
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			requestQueue.getRequest();
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (Exception e){
			}
			
		}
	}
}
