package com.test.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlatMapTest {
	
	
	
	
	
	public static void main(String[] args) {
		List<Foo> foos = new ArrayList<>();
		
		IntStream.range(1, 4)
		.forEach(i-> foos.add(new Foo("foo"+i)));
		
		foos.forEach(f->IntStream.range(1, 4)
				.forEach(i->f.bars.add(new Bar("Bar"+i+"<-"+f.name))));
		
		
		foos.stream()
		.flatMap(f->f.bars.stream())
		.forEach(b->System.out.println(b.name));
		
		System.out.println("===================================");
		
		IntStream.range(1, 4)
		.mapToObj(i->new Foo("Foo"+i))
		.peek(f->IntStream.range(1, 4).mapToObj(i->new Bar("Bar"+i+"<-"+f.name)).forEach(f.bars::add))
		.flatMap(f->f.bars.stream())
		.forEach(b->System.out.println(b.name));
		
		System.out.println("===================================");

		
	}
}
