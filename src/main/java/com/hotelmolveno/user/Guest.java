package com.hotelmolveno.user;

import java.util.ArrayList;

public class Guest extends User {

    private static int guestID = 0;

    public Guest(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {
        super(firstName, lastName, address, postalCode, city, country, telephoneNumber, emailAddress);  //constructor
    }

    private static ArrayList<User> userList = new ArrayList<>();    //initiate empty arrayList

    public Guest() {
        super();
    }

    //method to add users
    public static void addNewUser(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {

        User newUser = new Guest();
        ((Guest) newUser).setGuestID(guestID++);
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

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

}
