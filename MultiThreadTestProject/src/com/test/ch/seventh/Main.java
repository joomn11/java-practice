package com.test.ch.seventh;

public class Main {
	public static void main(String[] args) {
		System.out.println("main BEGIN");
		
		Host host = new Host();
		host.request(10, 'a');
		host.request(20, 'b');
		host.request(30, 'c');
		System.out.println("main END");
	}
}
