
//test

package com.hotelmolveno.hotel;

import com.hotelmolveno.reservation.ReservationRoom;
import com.hotelmolveno.user.Employee;
import com.hotelmolveno.user.Guest;
//<<<<<<< HEAD
import java.util.Scanner;


/*
This app enables the user to make, alter and view rooms, guests & reservations in the console
 */
//=======
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.hotelmolveno.reservation.ReservationRoom.alterReservationFromRoomList;
//>>>>>>> hbosch

public class RoomMakerApp {

    public RoomMakerApp() {
        super();
    }

    static boolean state = true;

    public static void main(String[] args) {
        RoomMakerApp roomMakerApp = new RoomMakerApp();
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println("\n##############################");
        System.out.println("#  Welcome to Hotel Molveno  #");
        System.out.println("##############################\n");
//<<<<<<< HEAD
//
//
//        RoomMakerApp roomMakerApp = new RoomMakerApp();
//        roomMakerApp.defaultRoomMaker();
//
//        // defaultRoomMaker();
//        Employee employee = new Employee();
//        employee.initiateTestEmployee();
//
//        // Employee.initiateTestEmployee();
//
//        Guest guest = new Guest();
//        guest.initiateTestGuests();
//        //Guest.initiateTestGuests();
//        ReservationRoom reservationRoom = new ReservationRoom();
//        reservationRoom.initiateTestReservations();
//
//        // ReservationRoom.initiateTestReservations();
//
//=======
        defaultRoomMaker();
        Employee.initiateTestEmployee();            //INIT
        Guest.initiateTestGuests();                 //INIT
        ReservationRoom.initiateTestReservations(); //INIT

//>>>>>>> hbosch
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

    private void userChoice() {
        ReservationRoom reservationRoom = new ReservationRoom();
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.print("\nEnter a number [1-12]: ");
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
//<<<<<<< HEAD
                Guest.changeGuestFromList();
//=======
//                guestChanger();
//>>>>>>> hbosch X
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
//                System.out.println("\n\n------------ NOT IMPLEMENTED YET ------------\n\n");
                alterReservationFromRoomList();
                break;
            case 10:
                System.out.println("You choose to remove a reservation");
                ReservationRoom.delReservationFromRoomList();
                break;
            case 11:
                System.out.println("You choose to print an overview of all Guest reservations");
                reservationRoom.getReservationRoomList();
                break;
            case 12:
                System.out.println("You choose to quit");
                state = false;
                break;
//<<<<<<< HEAD
//
//            default:
//                System.out.println("Please choose a number between 1 and 12");
//
//
//        }
//
//    }
//
//    public void defaultRoomMaker() { // method to make a few rooms when initializing the app
//        Room a = new Room(11, 2, 99.99);
//        Room b = new Room(12, 2, 99.99);
//        Room c = new Room(13, 2, 99.99);
//        Room d = new Room(14, 2, 99.99);
//        Room e = new Room(15, 2, 99.99);
//        Room f = new Room(16, 2, 99.99);
//        Room g = new Room(17, 2, 99.99);
//        Room h = new Room(18, 2, 99.99);
//        Room i = new Room(19, 2, 99.99);
//        Room j = new Room(20, 2, 99.99);
//
//        Hotel molveno = new Hotel();
//
//        molveno.addRoomToList(a);
//        molveno.addRoomToList(b);
//        molveno.addRoomToList(c);
//        molveno.addRoomToList(d);
//       molveno.addRoomToList(e);
//        molveno.addRoomToList(f);
//        molveno.addRoomToList(g);
//        molveno.addRoomToList(h);
//        molveno.addRoomToList(i);
//        molveno.addRoomToList(j);
//
//=======
        }
        if (x >= 1 || x <= 12) { // if user enters a number not in the menu:
            System.out.println("\nPlease choose an option number between: 1 and 12");
        }
    }

    private static void defaultRoomMaker() { // method to make a few rooms when initializing the app
        Hotel hotel = new Hotel();
        Room a = new Room(11, 2, 60.50);
        Room b = new Room(12, 2, 60.50);
        Room c = new Room(13, 2, 60.50);
        Room d = new Room(14, 2, 60.50);
        Room e = new Room(15, 2, 60.50);
        Room f = new Room(16, 3, 65.50);
        Room g = new Room(17, 3, 65.50);
        Room h = new Room(18, 3, 65.50);
        Room i = new Room(19, 4, 75.50);
        Room j = new Room(20, 4, 75.50);
        Room k = new Room(21, 4, 75.50);
        Room l = new Room(22, 4, 75.50);
        Room m = new Room(23, 5, 99.99);
        Room n = new Room(24, 5, 99.99);
        Room o = new Room(25, 5, 99.99);
        Room p = new Room(26, 5, 99.99);
        Room q = new Room(27, 8, 120.49);
        Room r = new Room(28, 8, 120.49);
        Room s = new Room(29, 10, 150.49);
        Room t = new Room(30, 12, 180.49);

        hotel.rooms.add(a);
        hotel.rooms.add(b);
        hotel.rooms.add(c);
        hotel.rooms.add(d);
        hotel.rooms.add(e);
        hotel.rooms.add(f);
        hotel.rooms.add(g);
        hotel.rooms.add(h);
        hotel.rooms.add(i);
        hotel.rooms.add(j);
        hotel.rooms.add(k);
        hotel.rooms.add(l);
        hotel.rooms.add(m);
        hotel.rooms.add(n);
        hotel.rooms.add(o);
        hotel.rooms.add(p);
        hotel.rooms.add(q);
        hotel.rooms.add(r);
        hotel.rooms.add(s);
        hotel.rooms.add(t);
//>>>>>>> hbosch
    }

    private void roomMaker() { // method to run if employee chooses to make a room
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
        System.out.println("\nHow many days to book the room? (use comma): ");
        double reservationPeriodInput = reader.nextDouble();
        System.out.println("\nEnter the starting date of the booking e.g. [30-6-2018]: ");
//        String reservationPeriodStart = reader.next();


        Room room = new Room(chosenRoomNumber, roomCapacity, roomPrice);
        room.setRoomNumber(chosenRoomNumber);
        room.setNumberOfGuests(roomCapacity);
        room.setPrice(roomPrice);
        room.setReserved(false);
        room.setReservationPeriodHr(reservationPeriodInput);
        System.out.println(room);
//<<<<<<< HEAD

        Hotel molveno = new Hotel();
        molveno.addRoomToList(room);

//=======
//        addRoomToList(room);
//>>>>>>> hbosch X
    }

    private void roomChanger() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("Enter the room number: ");
        int x = reader.nextInt();
        System.out.println("You entered room number " + Integer.toString(x));

        Hotel molveno = new Hotel();
        for (Room r : molveno.rooms) {

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

    //<<<<<<< HEAD
//    public void roomPrinter() {
//        Hotel hotel = new Hotel();
//
//        for (Room r : hotel.rooms) {
//            System.out.println(r);
//        }
//    }
//
//    public boolean roomNumberCheck(int roomNumber) {
//        Hotel hotel = new Hotel();
//        for (Room r : hotel.rooms) {
//
//=======
    public static void roomPrinter() {
        Hotel hotel = new Hotel();
        Calendar cal = Calendar.getInstance();
        Date x = cal.getTime();
        double diff;

        final int SECOND = 1000;        // no. of ms in a second
        final int MINUTE = SECOND * 60; // no. of ms in a minute
        final int HOUR = MINUTE * 60;   // no. of ms in an hour
        final int DAY = HOUR * 24;      // no. of ms in a day
        final int WEEK = DAY * 7;       // no. of ms in a week

        for (Room r : hotel.rooms) {
            Date y = r.reservationStartDate;
            diff = ChronoUnit.MILLIS.between(x.toInstant(), y.toInstant());
//            int weeks = (int) (diff / WEEK);
            int days = (int) ((diff % WEEK) / DAY);
//            int hours = (int) ((diff % DAY) / HOUR);
//            int minutes = (int) ((diff % HOUR) / MINUTE);
//            int seconds = (int) ((diff % MINUTE) / SECOND);

            if (!r.reserved) {
                System.out.println("Available:\t" + r);
            } else if (days > 1 && days < 6) {
                System.out.print("\nLimited available (Max for 6 days):\t\t" + r);
            } else if (days > 6 && days < 12) {
                System.out.print("\nshort-Term booked (Available after 6 days):\t\t" + r);
            } else if (days > 12 && days < 18) {
                System.out.print("\nMid-Term booked (Available after 12 days):\t\t" + r);
            } else {
                System.out.print("\nLong-Term booked (Available after 18 days):\t\t" + r);
            }
        }
    }

    private static boolean roomNumberCheck(int roomNumber) {
        Hotel hotel = new Hotel();
        for (Room r : hotel.rooms) {
//>>>>>>> hbosch
            if (r.roomNumber == roomNumber) {
                System.out.println("A room with room number " + roomNumber + " already exists");
                System.out.println(r);
                return true;
            }
        }
        return false;
    }

    public static void checkRoomISBooked() {
        Hotel hotel = new Hotel();
        for (Room r : hotel.rooms) {
            if (!r.getReserved())
                System.out.println(r);
        }
    }

    public static void removeOrAlterRoom(int roomID, int removeOrAlter) {
        Hotel hotel = new Hotel();
        Scanner x = new Scanner(System.in);
        boolean delete = false;
        int roomIDSto = 0;
//        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1);     //CHECK-IN DATE TO DEFAULT\\
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        for (Room r : hotel.rooms) {
            if (r.roomID == roomID) {
                System.out.println("Room with number: " + r.getRoomNumber() + " and ID: " + r.getRoomID() + " Found.");

                switch (removeOrAlter) {
                    case 0:
                        System.out.println("Continue defaulting the room detail information? [y/n]");
                        if (x.next().equals("y")) {
                            r.setReserved(false);
                            r.reservationPeriodHr = 0;
                            r.reservationStartDate = cal.getTime();
                            r.reservationEndDate = cal.getTime();
                            System.out.println("\nRoom details set to default!\n");
                        } else {
                        }
                        break;
                    case 1:
                        System.out.println("Continue DELETING the entire room ?? [yes/no]");
                        if (x.next().equals("yes")) {
                            delete = true;
                            roomIDSto = roomID;
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        if (delete) {
            System.out.println("Room " + hotel.rooms.get(roomIDSto).getRoomNumber() + "removed!");
            hotel.rooms.remove(roomIDSto);
        }
    }
}


