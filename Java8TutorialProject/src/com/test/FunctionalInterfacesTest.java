package com.test;

import com.test.interf.Converter;

public class FunctionalInterfacesTest {
	public static void main(String[] args) {
		Converter<String,Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("87632");
		System.out.println(converted);
		
		Converter<String,Integer> converter1 = Integer::valueOf;
		Integer converted1 = converter1.convert("28590");
		System.out.println(converted1);
		
		Something somthing = new Something();
		Converter<String,String> converter2 = somthing::startsWith;
		String converted2 = converter2.convert("Java");
		System.out.println(converted2);
	}
}


class Something{
	String startsWith(String s){
		return String.valueOf(s.charAt(0));
	}
}
