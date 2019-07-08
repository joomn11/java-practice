package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		String[] strArr = {"test", "stream", "coding"};
		List<String> strList = Arrays.asList(strArr);
		
		Arrays.sort(strArr);
		Collections.sort(strList);
		
		for(String str : strArr){
			System.out.println(str);
		}
		
		for(String str: strList){
			System.out.println(str);
		}
		
		String[] strArr2 = {"test", "stream", "coding"};
		List<String> strList2 = Arrays.asList(strArr2);
		
		// Stream Code 
		Stream<String> listStream = strList2.stream();
		Stream<String> arrStream = Arrays.stream(strArr2);
		
		listStream.sorted().forEach(System.out::println);
		arrStream.sorted().forEach(System.out::println);
		
		ArrayList<String> aa = listStream.sorted().collect(Collectors.toCollection(ArrayList::new));
	}
}
