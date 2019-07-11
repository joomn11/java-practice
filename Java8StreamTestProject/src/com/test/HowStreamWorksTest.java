package com.test;

import java.util.Arrays;
import java.util.List;

public class HowStreamWorksTest {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1","a2","b3","b4","d5","c6");
		
		myList
		.stream()
		.filter((s)->s.startsWith("a"))
		.map(String::toUpperCase)
		.sorted()
		.forEach(System.out::println);
		
		
		
		
		
	}
}
