package com.test.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FinalSimilar {
	public static void main(String[] args) {
		
	}
	
	public void findRetirees() {
		List<Person> allPeople = new ArrayList<>();
		int retirementAge = 55;
		List<Person> retirees = filter(allPeople, new Predicate<Person>() {
			@Override
			public boolean test(Person t) {
				
				return t.getAge() >= retirementAge;
			}
		});
//		retirementAge = 88;
	}
	
	private List<Person> filter(List<Person> people, Predicate<Person> predicate) {
		ArrayList<Person> matches = new ArrayList<>();
		for (Person p : people) {
			if (predicate.test(p)) {
				matches.add(p);
			}
		}
		return matches;
	}
}
