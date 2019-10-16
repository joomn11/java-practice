package com.test.lamda;

import java.util.ArrayList;
import java.util.List;

import com.test.interf.Factory;

public class ConstruReferen {
	public static void main(String[] args) {
		System.out.println("lskjfklsd");
		
//		String a = String::new;
		ConstruReferen test = new ConstruReferen();
		test.usage();
	}
	
	public void usage() {
		List<Object> list = new ArrayList<>();
		/*for(int i = 0; i<10; i++) {
			list.add(new Object());
		}*/
		initialize2(list, ()->new String("ss"));
		list.stream().forEach(x->System.out.println(x));
		
		initialize(list, Object::new);
		list.stream().forEach(x->System.out.println(x));
	}
	
	private void initialize (List<Object> list, Factory<Object> factory) {
		for(int i=0; i<10; i++) {
			list.add(factory.create());
		}
	}
	
	private <T> void initialize2(List<T> list, Factory<T> factory){
		for(int i=0; i<10; i++) {
			list.add(factory.create());
		}
	}
	
	
}
