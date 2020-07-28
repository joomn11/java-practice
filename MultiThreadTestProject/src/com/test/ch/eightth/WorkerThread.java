package com.test.ch.eightth;

public class WorkerThread extends Thread {
	private final Channel channel;
	private boolean terminated = false;

	public WorkerThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}

	@Override
	public void run() {

		while (!terminated) {
			try {
				Request request = channel.takeRequest();
				request.execute();
			} catch (InterruptedException e) {
				terminated = true;
				System.out.println(getName() + " WorkerThread interrupted! ");
			}
		}

		System.out.println(getName() + " WorkerThread ended!");
	}

	public void stopThread() {
		terminated = true;
		interrupt();
	}
}
