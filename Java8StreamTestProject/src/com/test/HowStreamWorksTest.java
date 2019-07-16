package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HowStreamWorksTest {
	
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1","a2","b3","b4","d5","c6");
		
		myList
		.stream()
		.filter((s)->s.startsWith("a"))
		.map(String::toUpperCase)
		.sorted()
		.forEach(System.out::println);
		
		
		Arrays.asList("a1", "a2", "af")
		.stream().findFirst().ifPresent(System.out::println);
		
		System.out.println("ssss");
		
		Stream.of("a1","a3","b3").findFirst().ifPresent(System.out::println);
		
		IntStream.range(84, 99).boxed().forEach(System.out::println);
		
		System.out.println(IntStream.range(84, 99).count());
		
		Arrays.stream(new int[]{1,2,3})
		.map(n->n*2+1)
		.average()
		.ifPresent(System.out::println);
		
		Stream.of("a34", "a2", "f48")
		.map(n->n.substring(1))
		.mapToInt(Integer::parseInt)
		.max()
		.ifPresent(System.out::println);
		
		IntStream.range(23, 50)
		.mapToObj(i-> "a"+i)
		.forEach(System.out::println);
		
		System.out.println("==================================");
		Stream.of("d1","a2","b1","b9","c")
		.filter(s->{
			System.out.println("filter: "+s);
			return true;
		})
		.forEach(System.out::println);
		
		System.out.println("==================================");
		
		Stream.of("d2", "a2", "b1", "b3", "c","a34")
		.map(s->{
			System.out.println("map: "+s);
			return s.toUpperCase();
		})
		.anyMatch(s->{
			System.out.println("anyMatch :"+ s);
			return s.startsWith("A");
		});
	}
}
