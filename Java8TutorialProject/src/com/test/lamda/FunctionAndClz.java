package com.test.lamda;

import java.util.function.Function;

public class FunctionAndClz {
	
	public static void main(String[] args) {
		System.out.println("sdddddddddddddd");
	}
	
	private String firstName = "Jack";
	
	public void example() {
		Function<String, String> addSurname = surname -> { // this.firstName가능 , furstName가능 
			return this.firstName + " " + surname ;
		};
		
		Function<String, String> addSurname1 = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return FunctionAndClz.this.firstName + " " + t; // this.firstName 불가능 
			}
		};
	}
}
