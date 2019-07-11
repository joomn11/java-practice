package com.test.interf;

//@FunctionalInterface
public interface Converter<F,T>{
	T convert(F from);
}
