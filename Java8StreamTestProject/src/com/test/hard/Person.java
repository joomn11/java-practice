package com.test.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	static List<Person> persons = Arrays.asList(
			new Person("Max", 34),
			new Person("Peter", 12),
			new Person("Pamela",12),
			new Person("David", 23)	);
	
	public static void main(String[] args) {
		
		List<Person> filtered = persons.stream()
		.filter(p->p.name.startsWith("P"))
		.collect(Collectors.toList());
		
		System.out.println(filtered);
	}
}
