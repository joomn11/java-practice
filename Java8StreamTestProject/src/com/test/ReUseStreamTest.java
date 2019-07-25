package com.test;

import java.util.stream.Stream;

public class ReUseStreamTest {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s->s.startsWith("a"));
		stream.anyMatch(s->true);
		
		stream.noneMatch(s->true);
		
	}
}
