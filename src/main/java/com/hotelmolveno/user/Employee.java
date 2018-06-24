package com.hotelmolveno.user;

import com.hotelmolveno.App;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.hotelmolveno.reservation.ReservationRoom.reservationRoomList;

public class Employee extends User {

    public static List<User> userListEmployee = new ArrayList<>();    //initiate empty arrayList

    public Employee(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {
        super(firstName, lastName, address, postalCode, city, country, telephoneNumber, emailAddress);  //constructor
    }

    public Employee() {
        super();
    }

    //method to add users
    public static void addNewUser(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {

        User newUser = new Employee();
        App.setCounterEmployee();
        newUser.setEmployeeID(App.getCounterEmployee());
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);
        newUser.setPostalCode(postalCode);
        newUser.setCity(city);
        newUser.setCountry(country);
        newUser.setTelephoneNumber(telephoneNumber);
        newUser.setEmailAddress(emailAddress);
        userListEmployee.add(newUser);
    }

    public static void initiateTestEmployee() {
        Employee.addNewUser("Dave", "Davidson", "Camblesteet", "583492", "New York", "US", "+13958543284", "dave@gmail.com");
        Employee.addNewUser("Alex", "Davidson", "Camblesteet", "583492", "New York", "US", "+13958543284", "alex@gmail.com");
        Employee.addNewUser("Max", "Davidson", "Camblesteet", "583492", "New York", "US", "+13958543284", "alex@gmail.com");
    }

    public static void getUsers() {
        for (User listUsers : userListEmployee) {
            System.out.println(listUsers);
        }
    }

    public static void searchEmployee(String firstName) {

        for (User myList : userListEmployee) {                                                  //ITERATE THROUGH GUEST LIST
            if (myList.getFirstName() == firstName) {
                System.out.print(myList.getFirstName() + "\t User exists. ");
                for (Map.Entry<Integer, Integer> entry : reservationRoomList.entrySet()) {    //ITERATE THROUGH RESERVATION LIST
                    if (entry.getKey() == myList.getEmployeeID()) {
                        System.out.println("With reservations id: " + entry.getKey());
                    }else{
                        System.out.println("");
                    }

                    break;
                }
            }
        }
    }


}



