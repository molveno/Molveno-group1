package com.hotelmolveno.hotel;

import java.util.Scanner;
import static com.hotelmolveno.hotel.Hotel.addRoomToList;
import static com.hotelmolveno.hotel.Hotel.rooms;

public class RoomMakerApp {

    static boolean state = true;

    public static void main(String[] args) {
        defaultRoomMaker();

        while (state) {
            printMenu();
        }
    }

    public static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Make a room");
        System.out.println("2. Alter a room");
        System.out.println("3. Print an overview of all rooms");
        System.out.println("4. Quit");

        userChoice();
    }

    public static void userChoice() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
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
                System.out.println("You choose to quit");
                state = false;
                break;

        }
        if (x > 4 || x < 1) { // if user enters a number not in the menu:
            System.out.println("Please choose 1, 2, 3 or 4");

        }

    }

    public static void defaultRoomMaker() { // method to make a few rooms when initializing the app
        Room a = new Room(11, 2, 99.99);
        Room b = new Room(12, 2, 99.99);
        Room c = new Room(13, 2, 99.99);
        Room d = new Room(14, 2, 99.99);

        rooms.add(a);
        rooms.add(b);
        rooms.add(c);
        rooms.add(d);

    }

    public static void roomMaker() { // method to run if employee chooses to make a room
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

    public static void roomChanger() {
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

    public static void roomPrinter() {
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public static boolean roomNumberCheck(int roomNumber) {
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

