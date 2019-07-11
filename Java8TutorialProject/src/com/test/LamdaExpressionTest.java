package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaExpressionTest {
	
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("def","abc", "jkl","ghi");
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(String a : names){
			System.out.println(a);
		}
		
		List<String> names2 = Arrays.asList("def","abc", "jkl","ghi");
		Collections.sort(names2, (String a, String b)->{
			return b.compareTo(a);
		});
		
		for(String a : names2){
			System.out.println(a);
		}
		
		List<String> names3 = Arrays.asList("def","abc", "jkl","ghi");
		Collections.sort(names3, (String a, String b)-> b.compareTo(a));
		for(String a : names3){
			System.out.println(a);
		}
		
		List<String> names4 = Arrays.asList("def","abc", "jkl","ghi");
		Collections.sort(names4, (a,b)->a.compareTo(b));
		for(String a : names4){
			System.out.println(a);
		}
		
	}
}
