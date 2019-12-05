package com.test.ch.sixth.strategy;

public interface ReadWriteStrategy {
	public abstract Object doRead() throws InterruptedException;
	public abstract void doWrite(Object arg) throws InterruptedException;
}
