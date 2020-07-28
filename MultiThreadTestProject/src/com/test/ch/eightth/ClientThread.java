package com.test.ch.eightth;

import java.util.Random;

public class ClientThread extends Thread{
	private final Channel channel;
	private static final Random random = new Random();
	
	private boolean terminated = false;
	public ClientThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}
	
	@Override
	public void run() {
		try {
			for (int i=0; !terminated; i++) {
				Request request = new Request(getName(), i);
				channel.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
			terminated = true;
			System.out.println(getName()+ " ClientThread interrupted! ");
		}
		System.out.println(getName()+ " ClientThread ended!");
	}

	public void stopThread() {
		terminated = true;
		interrupt();
	}
}
