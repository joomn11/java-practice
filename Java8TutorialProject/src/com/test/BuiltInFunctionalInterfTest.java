package com.test;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.test.pojo.Person;

public class BuiltInFunctionalInterfTest {
	
	
	public static void main(String[] args) {
		Predicate<String> predicate = (s)-> s.length() > 0;
		
		System.out.println(predicate.test("foo"));
		System.out.println(predicate.negate().test("foo"));
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		
		Object a = new Object();
		Boolean b = Boolean.FALSE;
		System.out.println(nonNull.test(null));
		System.out.println(nonNull.test(Boolean.FALSE));
		System.out.println(isNull.test(null));
		System.out.println(isNull.test(Boolean.TRUE));
		
		System.out.println("------------");
		
		System.out.println(isEmpty.test(""));
		System.out.println(isEmpty.test("sdf"));
		
		System.out.println("------------");
		
		System.out.println(isNotEmpty.test(""));
		System.out.println(isNotEmpty.test("lsdkfj"));
		System.out.println("--------------------------------------");
		
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		
		System.out.println(backToString.apply("234"));
		System.out.println(toInteger.apply("53234"));
		System.out.println("--------------------------------------");
		
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();
		
		Consumer<Person> greeter = (p)->System.out.println("Hello, "+ p.firstName);
		greeter.accept(new Person("eunjoo", "kang"));
		System.out.println("--------------------------------------");

		Comparator<Person> comparator = (p1,p2)-> p1.firstName.compareTo(p2.firstName);
		
		Person p1 = new Person("Alice", "Eunice");
		Person p2 = new Person("Eunjoo", "Kang");
		
		System.out.println(comparator.compare(p1, p2));
		System.out.println(comparator.reversed().compare(p1, p2));
		System.out.println("--------------------------------------");

		Optional<String> optional = Optional.of("TestA");
		
		optional.isPresent();
		System.out.println(optional.get());
		System.out.println(optional.orElse("other"));
		optional.ifPresent((s)->System.out.println(s.charAt(0)));
	
	}
}
