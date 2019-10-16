package com.test.interf;

@FunctionalInterface
public interface Factory<T> {
	T create() ;
}
