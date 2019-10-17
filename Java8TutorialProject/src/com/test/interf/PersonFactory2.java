package com.test.interf;

import java.time.LocalDate;

import com.test.lamda.Person;

@FunctionalInterface
public interface PersonFactory2 {
	Person create(String forename, String surname, LocalDate birthday, String email, int age);
}
