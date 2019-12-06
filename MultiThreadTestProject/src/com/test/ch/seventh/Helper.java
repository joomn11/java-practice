package com.test.ch.seventh;

public class Helper {

	public void handle(int cnt, char c) {
		System.out.println(" handle(" + cnt + ", " + c + ") BEGIN");
		
		for (int i=0; i<cnt; i++) {
			slowly();
			System.out.print(c);
		}
		
		System.out.println("");
		System.out.println(" handle("+ cnt + ", "+ c + ") END");
	}

	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
