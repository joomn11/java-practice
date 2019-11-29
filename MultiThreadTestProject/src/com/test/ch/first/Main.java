package com.test.ch.first;

public class Main {
	
	
	public static void main(String[] args) {
		
		MyThread my = new MyThread();
		my.start();
		for(int i=0; i<10000; i++) {
			System.out.print("Good!");
		}
	}
}
