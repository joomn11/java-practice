package com.test.lamda.except;

import java.util.function.Consumer;

public class ExceptionHandlingExample {
	public static void main(String[] args) {
		
	}
	
	public static void runInSequence (Runnable first, Runnable second) {
		first.run();
		second.run();
	}
	
	public static void runInSequence2 (Runnable first, Runnable second) {
		new Thread(()->{
			first.run();
			second.run();
		}).start();
		// this case, client cannot has a chance to handle exception
		// because, in thread they catch exception
	}
	
	public static void runInSequence3 (Runnable first, Runnable second) {
		new Thread(()->{
			try {
				first.run();
				second.run();
			} catch (Exception e) {
				// do somethings
			}
			
		}).start();
	}
	
	public static void runInSequence4 (Runnable first, Runnable second, 
			Consumer<Throwable> exehandler) {
		new Thread(()->{
			try {
				first.run();
				second.run();
			} catch (Exception e) {
				exehandler.accept(e);
			}
			
		}).start();
	}
	
	public void transfer (BankAccount a, BankAccount b, Integer amount) {
		Runnable debit = ()-> a.debit(amount);
		Runnable credit = ()->b.credit(amount);
		
		try {
			runInSequence(debit, credit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void nonBlockingTransfer (BankAccount a, BankAccount b, Integer amount) {
		Runnable debit = ()-> a.debit(amount);
		Runnable credit = ()->b.credit(amount);
		
		runInSequence4(debit, credit, (e)->{
			// handle exception in here
		});
	}
	
	public void transfer2 (BankAccount a, BankAccount b, Integer amount) {
		Runnable debit = ()-> {
			try {
				a.debit2(amount);
			} catch (InsufficientFundsExeception e) {
				e.printStackTrace();
			}
		};
		Runnable credit = ()-> {
			try {
				b.credit2(amount);
			} catch (InsufficientFundsExeception e) {
				e.printStackTrace();
			}
		};
		
		try {
			runInSequence(debit, credit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void transfer3 (BankAccount a, BankAccount b, Integer amount) {
		Callable<InsufficientFundsExeception> debit = ()-> a.debit(amount);
		Callable<InsufficientFundsExeception> credit = ()->b.credit(amount);
		
		Runnable debit2 = unchecked(()->a.debit2(amount));
		Runnable credit2 = unchecked(()->b.credit2(amount));
		runInSequence(debit2, credit2);
		try {
//			runInSequence(debit, credit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Runnable unchecked(Callable<InsufficientFundsExeception> function) {
		return ()->{
			try {
				function.call();
			} catch (InsufficientFundsExeception e) {
				
			}
		};
	}
}

