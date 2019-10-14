package com.test.lamda;

import java.util.Arrays;
import java.util.Comparator;

public class BasicGramma {
	//static List<Integer> numbers = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		Integer[] numbers = new Integer[10];
		
		Arrays.sort(numbers, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			};
		});
		
		Arrays.sort(numbers,(first,second)->first.compareTo(second));
		
		Comparator<Integer> ascending = (first,second)->first.compareTo(second);
		Arrays.sort(numbers,ascending);
		
	}
}
