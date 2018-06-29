package com.hotelmolveno.hotel;

import com.hotelmolveno.reservation.ReservationRoom;
import com.hotelmolveno.user.Employee;
import com.hotelmolveno.user.Guest;
import java.util.Scanner;
import static com.hotelmolveno.hotel.Hotel.addRoomToList;
import static com.hotelmolveno.hotel.Hotel.rooms;

/*
This app enables the user to make, alter and view rooms, guests & reservations in the console
 */

public class RoomMakerApp {

    static boolean state = true;

    public static void main(String[] args) {
        System.out.println("\n##############################");
        System.out.println("#  Welcome to Hotel Molveno  #");
        System.out.println("##############################\n");

        Employee.initiateTestEmployee();            //INIT
        Guest.initiateTestGuests();                 //INIT
        ReservationRoom.initiateTestReservations(); //INIT

        RoomMakerApp roomMakerApp = new RoomMakerApp();
        roomMakerApp.defaultRoomMaker();

        // defaultRoomMaker();
        Employee employee = new Employee();
        employee.initiateTestEmployee();

        // Employee.initiateTestEmployee();

        Guest guest = new Guest();
        guest.initiateTestGuests();
        //Guest.initiateTestGuests();
        ReservationRoom reservationRoom = new ReservationRoom();
        reservationRoom.initiateTestReservations();

        // ReservationRoom.initiateTestReservations();

        while (state) {
            roomMakerApp.printMenu();
        }
    }

    public void printMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("-------------------------------------------------");
        System.out.println("| 1. Make a room" + "\t\t\t\t\t\t\t\t|");
        System.out.println("| 2. Alter a room" + "\t\t\t\t\t\t\t\t|");
        System.out.println("| 3. Print an overview of all rooms" + "\t\t\t\t|");
        System.out.println("|------------------------------------------------");
        System.out.println("| 4. Add Guest" + "\t\t\t\t\t\t\t\t\t|");
        System.out.println("| 5. Alter a Guest record" + "\t\t\t\t\t\t|");
        System.out.println("| 6. Remove a Guest record" + "\t\t\t\t\t\t|");
        System.out.println("| 7. Print an overview of all Guest records" + "\t\t|");
        System.out.println("|------------------------------------------------");
        System.out.println("| 8. Add Reservation" + "\t\t\t\t\t\t\t|");
        System.out.println("| 9. Alter a Reservation" + "\t\t\t\t\t\t|");
        System.out.println("| 10. Remove Reservation" + "\t\t\t\t\t\t|");
        System.out.println("| 11. Print an overview of all Reservations" + "\t\t|");
        System.out.println("-------------------------------------------------");
        System.out.println("12. Quit");

        RoomMakerApp roomMakerApp = new RoomMakerApp();
        roomMakerApp.userChoice();
    }

    public void userChoice() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("\nEnter a number [1-12]: ");
        int x = reader.nextInt();
//once finished
        // reader.close();
        System.out.println("User input was " + Integer.toString(x));

        switch (x) {
            case 1:
                System.out.println("You choose to make a room");
                roomMaker();
                break; //
            case 2:
                System.out.println("You choose to alter a room");
                roomChanger();
                break; //
            case 3:
                System.out.println("You choose to print a room overview");
                roomPrinter();
                break;
            case 4:
                System.out.println("You choose to add a Guest");
                Guest.addNewGuest();
                break;
            case 5:
                System.out.println("You choose to alter Guest record");
                Guest.changeGuestFromList();
                break;
            case 6:
                System.out.println("You choose to remove a Guest record");
                Guest.delGuestFromList();
                break;
            case 7:
                System.out.println("You choose to print an overview of all Guest records");
                Guest.getGuestList();
                break;
            case 8:
                System.out.println("You choose to add a reservation");
                ReservationRoom.addToReservationRoomList();
                break;
            case 9:
                System.out.println("You choose to alter a reservation");
                System.out.println("\n\n------------ NOT IMPLEMENTED YET ------------\n\n");
                break;
            case 10:
                System.out.println("You choose to remove a reservation");
                ReservationRoom.delReservationFromRoomList();
                break;
            case 11:
                System.out.println("You choose to print an overview of all Guest reservations");
                ReservationRoom reservationRoom = new ReservationRoom();
                reservationRoom.getReservationRoomList();
                break;
            case 12:
                System.out.println("You choose to quit");
                state = false;
                break;

            default:
                System.out.println("Please choose a number between 1 and 12");
=======

        }
       
    }

    public void defaultRoomMaker() { // method to make a few rooms when initializing the app
        Room a = new Room(11, 2, 99.99);
        Room b = new Room(12, 2, 99.99);
        Room c = new Room(13, 2, 99.99);
        Room d = new Room(14, 2, 99.99);
        Room e = new Room(15, 2, 99.99);
        Room f = new Room(16, 2, 99.99);
        Room g = new Room(17, 2, 99.99);
        Room h = new Room(18, 2, 99.99);
        Room i = new Room(19, 2, 99.99);
        Room j = new Room(20, 2, 99.99);

        rooms.add(a);
        rooms.add(b);
        rooms.add(c);
        rooms.add(d);
        rooms.add(e);
        rooms.add(f);
        rooms.add(g);
        rooms.add(h);
        rooms.add(i);
        rooms.add(j);

    }

    public void roomMaker() { // method to run if employee chooses to make a room
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("Enter a room number: ");
        int chosenRoomNumber = reader.nextInt();
        System.out.println("You entered room number " + Integer.toString(chosenRoomNumber));
        boolean roomAlreadyExists = roomNumberCheck(chosenRoomNumber);

        if (roomAlreadyExists) {
            roomMaker();
        }

        System.out.println("How many guests fit in the room? ");
        int roomCapacity = reader.nextInt();
        System.out.println("The capacity of the room is " + Integer.toString(roomCapacity));

        System.out.println("What is the price of the room? (use comma) ");
        double roomPrice = reader.nextDouble();
        System.out.println("The price of the room is " + Double.toString(roomPrice));

        Room room = new Room(chosenRoomNumber, roomCapacity, roomPrice);
        room.setRoomNumber(chosenRoomNumber);
        room.setNumberOfGuests(roomCapacity);
        room.setPrice(roomPrice);
        System.out.println(room);
        addRoomToList(room);

    }

    public void roomChanger() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("Enter the room number: ");
        int x = reader.nextInt();
        System.out.println("You entered room number " + Integer.toString(x));

        for (Room r : rooms) {

            if (r.roomNumber == x) {
                System.out.println("A room with room number " + x + " exists");
                System.out.println(r);
                System.out.println("What is the new price of the room? (use comma) ");
                double roomPrice = reader.nextDouble();
                System.out.println("The new price of the room is " + Double.toString(roomPrice));
                r.setPrice(roomPrice);
                System.out.println(r);
            }
        }

    }

    public void roomPrinter() {
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public boolean roomNumberCheck(int roomNumber) {
        for (Room r : rooms) {

            if (r.roomNumber == roomNumber) {
                System.out.println("A room with room number " + roomNumber + " already exists");
                System.out.println(r);
                return true;
            }


            }
        return false;

    }
}

