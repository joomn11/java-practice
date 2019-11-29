package com.test.ch.third;

import java.util.LinkedList;

public class RequestQueue {
	private final LinkedList<Request> quequ = new LinkedList<>();
	
	public synchronized Request getRequest() {
		while (quequ.size() > 0) {
			try {
				wait();
			} catch(Exception e){
			}
		}
		return quequ.removeFirst();
	}
	
	public synchronized void putRequest(Request request) {
		quequ.addLast(request);
		notifyAll();
	}
}
