package com.test;

import com.test.interf.Converter;
import com.test.interf.PersonFactory;
import com.test.pojo.Person;

public class MethodConstructorReferencesTest {
	
	static int outerStaticNum = 878 ;
	int outerNum;
	
	void testScopes(){
		Converter<Integer, String> converter = (from) -> {
			outerNum = 32;
			return String.valueOf(from+outerNum+ outerStaticNum);
		};
		System.out.println("testScopes");
		System.out.println(converter.convert(124));
	}
	
	public static void main(String[] args) {
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("eunjoo", "Kang");
		
		System.out.println(person.firstName);
		System.out.println(person.lastName);
		
		final int num = 1 ;
		Converter<Integer, String> stringConverter = (from) -> String.valueOf(from+num);
		System.out.println(stringConverter.convert(44));
		
		int num2 = 9;
		Converter<Integer , String > stringConverter2 = (from) -> String.valueOf(from + num2);
		System.out.println(stringConverter2.convert(43));
		//num2 = 8;	
		
		MethodConstructorReferencesTest test = new MethodConstructorReferencesTest();
		test.testScopes();
	}
	
}
