package com.test.hard;

public class ReduceTest {
	public static void main(String[] args) {
		
		Person.persons
		.stream()
		.reduce((p1,p2)-> p1.age>p2.age ? p1:p2)
		.ifPresent(System.out::println);
		
		System.out.println("=========================================");
		Person result = Person.persons.stream().reduce(new Person("",0), (a1,a2)->{
			a1.age += a2.age;
			a1.name += a2.name;
			return a1;
		});
		
		System.out.format("name=%s ; age=%s \n", result.name, result.age);
		System.out.println("=========================================");
		
		Integer ageSum = Person.persons.stream()
				.reduce(0, (sum, p)->sum+=p.age, (sum1, sum2)->sum1+sum2);
		System.out.println(ageSum);
		
		Integer ageSum2 = Person.persons.parallelStream()
				.reduce(0, (sum, p)->{
					System.out.format("accumulator : sum = %s ; person = %s \n", sum,p);
					return sum+=p.age;
				}, (sum1, sum2)->{
					System.out.format("combiner : sum1 = %s ; sum2 = %s \n", sum1, sum2);
					return sum1+sum2;
				});
		System.out.println(ageSum2);
	}
}
