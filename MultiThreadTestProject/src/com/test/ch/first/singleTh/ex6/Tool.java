package com.test.ch.first.singleTh.ex6;

public class Tool {

	private final String name;
	
	public Tool(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[ " + name + " ]";
	}

}
