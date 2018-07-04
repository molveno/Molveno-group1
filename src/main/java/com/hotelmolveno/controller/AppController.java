package com.hotelmolveno.controller;

import com.hotelmolveno.hotel.RoomStore;
import com.hotelmolveno.reservation.ReservationStore;
import com.hotelmolveno.user.EmployeeStore;
import com.hotelmolveno.user.GuestStore;

import java.util.Calendar;
import java.util.Scanner;

public class AppController {

    private RoomStore roomStore = new RoomStore();                      //NEW UNIQUE ROOM-STORE
    private GuestStore guestStore = new GuestStore();                   //NEW UNIQUE GUEST-STORE
    private EmployeeStore employeeStore = new EmployeeStore();          //NEW UNIQUE EMPLOYEE-STORE
    private ReservationStore reservationStore = new ReservationStore(); //NEW UNIQUE RESERVATION-STORE

    private boolean state = true;

    public void run() {

        this.welcome();
        this.loadTestData();


        while (state) {
            printMenu();
        }
    }

    private void welcome() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println("\n#######################################");
        System.out.println("#  Welcome to RoomStore Molveno  v2.2 #");
        System.out.println("#######################################\n");
    }

    private void loadTestData() {
        roomStore.defaultRoomMaker();                  //INIT STANDARD RECORDS
        guestStore.initiateTestGuests();                                        //INIT STANDARD RECORDS
        employeeStore.initiateTestEmployee();                                   //INIT STANDARD RECORDS
        reservationStore.initiateTestReservations(roomStore, guestStore);       //INIT STANDARD RECORDS
    }

    public void printMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("-------------------------------------------------");
        System.out.println("| 1. Make a room" + "\t\t\t\t\t\t\t\t|");
        System.out.println("| 2. Alter a room" + "\t\t\t\t\t\t\t\t|");
        System.out.println("| 3. List all rooms" + "\t\t\t\t\t\t\t\t|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("| 4. Add Guest" + "\t\t\t8. Add Employee\t\t\t|");
        System.out.println("| 5. Alter a Guest" + "\t\t9. Alter Employee\t\t|");
        System.out.println("| 6. Remove a Guest" + "\t\t10. Remove Employee\t\t|");
        System.out.println("| 7. List all Guests" + "\t11. List Employee\t\t|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("| 12. Add Reservation" + "\t\t\t\t\t\t\t|");
        System.out.println("| 13. Alter a Reservation" + "\t\t\t\t\t\t|");
        System.out.println("| 14. Remove Reservation" + "\t\t\t\t\t\t|");
        System.out.println("| 15. List all Reservations" + "\t\t\t\t\t\t|");
        System.out.println("-------------------------------------------------");
        System.out.println("| 16. Quit" + "\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("-------------------------------------------------");

        menuOption();
    }

    private void menuOption() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.print("\nEnter a number [1-12]: ");
        int x = reader.nextInt();
        System.out.println("User input was " + Integer.toString(x));

        switch (x) {
            case 1:
                System.out.println("You choose to make a room");
                roomStore.roomMaker();
                break;
            case 2:
                System.out.println("You choose to alter a room");
                roomStore.roomChanger();
                break;
            case 3:
                System.out.println("You choose to print a room overview");
                roomStore.roomPrinter();
                break;
            case 4:
                System.out.println("You choose to add an guest");
                guestStore.addNewGuest();
                break;
            case 5:
                System.out.println("You choose to alter an guest record");
                guestStore.guestChanger();
                break;
            case 6:
                System.out.println("You choose to remove an guest record");
                guestStore.delGuestFromList();
                break;
            case 7:
                System.out.println("You choose to print an overview of all guest records");
                guestStore.getGuests();
                break;

            case 8:
                System.out.println("You choose to add an employee");
                employeeStore.addNewEmployee();
                break;
            case 9:
                System.out.println("You choose to alter an employee record");
                employeeStore.employeeChanger();
                break;
            case 10:
                System.out.println("You choose to remove an employee record");
                employeeStore.delEmployeeFromList();
                break;
            case 11:
                System.out.println("You choose to print an overview of all employee records");
                employeeStore.getEmployeeList();
                break;

            case 12:
                System.out.println("You choose to add a reservation");
                reservationStore.addToReservationRoomList(roomStore, guestStore);
                break;
            case 13:
                System.out.println("You choose to alter a reservation");
                reservationStore.alterReservationFromRoomList(roomStore, guestStore);
                break;
            case 14:
                System.out.println("You choose to remove a reservation");
                reservationStore.delReservationFromRoomList(roomStore, guestStore);
                break;
            case 15:
                System.out.println("You choose to print an overview of all guest reservations");
                reservationStore.getReservationRoomList(roomStore, guestStore);
                break;
            case 16:
                System.out.println("You choose to quit");
                state = false;
                break;
        }
        if (x >= 1 || x <= 16) { // if user enters a number not in the menu:
            System.out.println("\nPlease choose an option number between: 1 and 12");
        }
    }
}



