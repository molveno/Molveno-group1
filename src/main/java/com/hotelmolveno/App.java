package com.hotelmolveno;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.user.Employee;
import com.hotelmolveno.user.Guest;

// is this now on release branch?

public class App{

    public static void main(String[]args){
    Room newRoom = new Room(0, 0, 4);
    newRoom.setReserved(true);
    System.out.println(newRoom.getRoomID());

        Employee.addNewUser("Dave", "Davidson", "Camblesteet","583492","New York", "US", "+13958543284","dave@gmail.com");
        Employee.addNewUser("Alex", "Davidson", "Camblesteet","583492","New York", "US", "+13958543284","alex@gmail.com");
        Employee.addNewUser("Jack", "Davidson", "Camblesteet","583492","New York", "US", "+13958543284","jack@gmail.com");
        Employee.addNewUser("Steve", "Davidson", "Camblesteet","583492","New York", "US", "+13958543284","steve@gmail.com");

        Guest.addNewUser("Gerard", "Joling", "Camblesteet","583492","New York", "US", "+13958543284","steve@gmail.com");


        Employee.printUsers();
        Guest.printUsers();
       }
}

