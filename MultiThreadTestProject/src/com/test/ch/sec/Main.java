package com.test.ch.sec;

public class Main {
	
	/*public static void main(String[] args) {
		Person alice = new Person("Alice", "Alaska");
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
	}*/
	private static final long CALL_CNT = 1000000000L;
	
	public static void main(String[] args) {
		trial("NotSynch", CALL_CNT, new NotSynch());
		trial("Synch", CALL_CNT, new Synch());
		
	}

	private static void trial(String msg, long cnt, Object obj) {
		System.out.println(msg + " : BEGIN");
		long start = System.currentTimeMillis();
		
		for(long i = 0; i<cnt; i++) {
			obj.toString();
		}
		
		System.out.println(msg + " : END");
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time = " + (end - start) + "msce.");
	}
	
	
}
