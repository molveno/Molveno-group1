package com.hotelmolveno.user;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User{

//    private int employeeID;

    public Employee(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {
        super(firstName, lastName, address, postalCode, city, country, telephoneNumber, emailAddress);  //constructor
    }

    private static List<User> userList = new ArrayList<>();    //initiate empty arrayList

    public Employee() {
        super();
    }

    //method to add users
    public static void addNewUser(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress){

        User newUser = new Employee();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);
        newUser.setPostalCode(postalCode);
        newUser.setCity(city);
        newUser.setCountry(country);
        newUser.setTelephoneNumber(telephoneNumber);
        newUser.setEmailAddress(emailAddress);
        userList.add(newUser);
    }

    public static void printUsers() {
        for (User listUsers : userList) {
            System.out.println(listUsers);
        }
    }
}



