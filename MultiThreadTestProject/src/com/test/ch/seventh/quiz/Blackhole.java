package com.test.ch.seventh.quiz;

public class Blackhole {
	public static void enter(Object obj) {
		System.out.println("Step 1");
		
		magic(obj);
		
		System.out.println("Step 2");
		
		synchronized (obj) {
			System.out.println("Step 3 (never reached here)");
		}
	}

	private static void magic(Object obj) {
		Thread thread = new Thread(){
			public void run() {
				synchronized (obj) {
					/*synchronized (this) {
						this.setName("Locked");
						this.notifyAll();
					}*/
					while(true){
//						System.out.println("while in obj sync");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
//		synchronized (thread) {
			thread.setName("");
			thread.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/*while(thread.getName().equals("")) {
				try {
					System.out.println("while in thread sync");
					thread.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
			System.out.println("out of thread sync while");
//		}
		
	}
}
