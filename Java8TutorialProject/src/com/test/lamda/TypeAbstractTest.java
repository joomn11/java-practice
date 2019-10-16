package com.test.lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.test.interf.Calculation;
import com.test.interf.Conversion;
import com.test.interf.Converter;

public class TypeAbstractTest {
	public static void main(String[] args) {
		Calculation addition = (x, y)-> x+y;
		Calculation subtraction = (x,y)->x-y;
		
		System.out.println(calculate(addition, 234, 99));
		System.out.println(calculate(subtraction, 542, 99));
		
		System.out.println("------------------------------------------------------");
		
		List<String> names = emptyList();
		
		// processNames(Collections.<Object>emptyList());
		processNames(Collections.<String>emptyList());
		processNames(Collections.emptyList());
		
		String.valueOf(true);
//		String::valueOf;
//		(x)->String.valueOf(x);
		
		System.out.println(convert(100, (num)->String.valueOf(num)));
		System.out.println(convert(100, String::valueOf));
		System.out.println(convert2(11, String::valueOf));
	}
	
	static Integer calculate(Calculation operation, Integer x, Integer y) {
		return operation.apply(x, y);
	}
	
	public static final <T> List<T> emptyList() {
		return new ArrayList<T>();
	}
	
	static void processNames(List<String> names) {
		System.out.println("hello" + names);
	}
	
	public static String convert (Integer number, Conversion function) {
		return function.convert(number);
	}
	
	public static String convert2 (Integer number, Converter<Object, String> function) {
		return function.convert(number);
	}
}
