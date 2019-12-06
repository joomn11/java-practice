package com.test.ch.seventh;

public class Host {
	private final Helper helper = new Helper();
	
	public void request(final int cnt, final char c) {
		System.out.println("request(" + cnt + ", " + c + ") BEGIN");
		
		new Thread() {
			public void run() {
				helper.handle(cnt, c);
			};
		}.start();
		System.out.println("request(" + cnt + ", " + c + ") END");
	}
}
