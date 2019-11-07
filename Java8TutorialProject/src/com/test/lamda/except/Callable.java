package com.test.lamda.except;

@FunctionalInterface
public interface Callable<E extends Exception> {
	void call() throws E;
}
