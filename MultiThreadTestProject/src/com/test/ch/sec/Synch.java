package com.test.ch.sec;

public class Synch {
	private final String name = "Synch";
	
	@Override
	public synchronized String toString() {
		return "[ " + name + " ]";
	}
}
