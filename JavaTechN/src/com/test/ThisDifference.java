package com.test;

public class ThisDifference {
	public static void main(String[] args) {
		new ThisDifference().print();
	}
	
	public void print() {
		Runnable anonClass = new Runnable() {
			
			@Override
			public void run() {
				verifyRunnable(this);
				
			}
		};
		anonClass.run();
		 
		Runnable lambda = () -> verifyRunnable(ThisDifference.this);
		lambda.run();
		
		Runnable lambda2 = () -> verifyRunnable(this);
		lambda2.run();
	}
	
	public void verifyRunnable(Object obj) {
		if (obj instanceof Runnable) {
			System.out.println("Runnable");
		} else if (obj instanceof ThisDifference) {
			System.out.println("ThisDifference");
		} else {
			System.out.println(obj.getClass().toString());
		}
//		System.out.println(obj instanceof Runnable);
	}
}
