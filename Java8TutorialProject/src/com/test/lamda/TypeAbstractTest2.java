package com.test.lamda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.test.interf.Factory;
import com.test.interf.PersonFactory2;

public class TypeAbstractTest2 {
	public static void main(String[] args) {
		Collections.sort(Arrays.asList(5,12,3), Comparators::ascending);
		
		Collections.sort(Arrays.asList(3,343,22), (a,b)->Comparators.ascending(a, b));
		
		Callable<String> c = ()->"Hello";
//		Factory<String> f = c::call;
		
		String x = "";
		function(x::toString);
	}
	
	public void example() {
		String forename = "s", surname = "ss", email = "fff";
		LocalDate birthday = null;
		int age = 3;
		
//		PersonFactory2 factory = (a,b,c,d,e)-> new Person(a,b,c,d,e);
		PersonFactory2 factory = Person::new;
		Person person = factory.create(forename, surname, birthday, email, age);
		System.out.println(person);
		
	}
	
	public static String function(Supplier<String> supplier) {
		return supplier.get();
	}
	
	public static class Comparators {
		public static Integer ascending(Integer first, Integer second) {
			return first.compareTo(second);
		}
	}
}
