package com.test.hard;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HightLevelCollectOperationTest {
	public static void main(String[] args) {
		//Person test = new Person("aa", 33);
		
		List<Person> filtered = Person.persons.stream()
		.filter(p->p.name.startsWith("P"))
		.collect(Collectors.toList());
		
		System.out.println(filtered);
		System.out.println("=========================================="	);
		
		
		Map<Integer, List<Person>> personsByAge = Person.persons
				.stream()
				.collect(Collectors.groupingBy(p->p.age));
		personsByAge.forEach((age,p)->System.out.printf("age : %s : %s \n", age, p));
		
		System.out.println("=========================================="	);

		Double averageAge = Person.persons
				.stream()
				.collect(Collectors.averagingInt(p->p.age));
		System.out.println(averageAge);
		
		System.out.println("=========================================="	);

		IntSummaryStatistics ageSummary = Person.persons
				.stream()
				.collect(Collectors.summarizingInt(p->p.age));
		
		System.out.println(ageSummary);
		
		System.out.println("=========================================="	);
		
		String phrase = Person.persons
				.stream()
				.filter(p->p.age>=18)
				.map(p->p.name)
				.collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
		
		System.out.println(phrase);
		System.out.println("=========================================="	);

		Map<Integer, String> map = Person.persons
				.stream()
				.collect(Collectors.toMap(p->p.age, p->p.name,(name1,name2)->name1+";"+name2));
		
		System.out.println(map);
		System.out.println("=========================================="	);

		Collector<Person,StringJoiner,String> personNameCollector = 
				Collector.of(
						()-> new StringJoiner(" | "), 
						(j,p)->j.add(p.name.toUpperCase()),
						(j1,j2)->j1.merge(j2),
						StringJoiner::toString);
		
		String names = Person.persons.stream().collect(personNameCollector);
		System.out.println(names);
				
	}
}
