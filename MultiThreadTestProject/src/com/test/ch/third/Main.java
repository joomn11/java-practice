package com.test.ch.third;

public class Main {
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		
		new ClientThread(requestQueue, "Alice", 3147802L).start();
		new ClientThread(requestQueue, "Boabbay", 6529865L).start();
		
	}
}
