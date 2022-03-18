package com.test.yaml;

import java.util.List;

import lombok.Data;

@Data
public class Customer {

    private String firstName;
    private String lastName;
    private int age;

    private List<Contact> contactDetails;
    private Address homeAddress;

}
