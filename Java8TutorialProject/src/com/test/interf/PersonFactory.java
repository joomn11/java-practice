package com.test.interf;

import com.test.pojo.Person;

public interface PersonFactory <P extends Person>{
	P create(String first, String last);
}
