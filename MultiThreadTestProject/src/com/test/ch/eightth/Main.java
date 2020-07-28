package com.test.ch.eightth;

public class Main {
	public static void main(String[] args) {
		Channel channel = new Channel(5);
		channel.startWorkers();
		
		ClientThread a = new ClientThread("Alice", channel);
		ClientThread b = new ClientThread("Bobby", channel);
		ClientThread c = new ClientThread("Chris", channel);
		
		a.start();
		b.start();
		c.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		
		a.stopThread();
		b.stopThread();
		c.stopThread();
		
		channel.stopAllWorkers();
		
	}
}
