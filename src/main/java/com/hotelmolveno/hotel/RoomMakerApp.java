package com.hotelmolveno.hotel;
import java.util.Scanner;


public class RoomMakerApp {

    public static void main(String[] args) {
        printMenu();
    }

    public static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Make a room");
        System.out.println("2. Alter a room");
        System.out.println("3. Quit");
        userChoice();
    }

    public static void userChoice() {

        try {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter a number: ");
            int x = reader.nextInt();
//once finished
            reader.close();
            System.out.println("User input was " + Integer.toString(x));

            switch (x) {
                case 1:
                    System.out.println("You choose to make a room");
                    roomReservation();
                    break; //
                case 2:
                    System.out.println("You choose to alter a room");
                    break; //
                case 3:
                    System.out.println("You choose to quit");
                    break;
            }

            if (x > 3 || x < 1) { // if user enters a number not in the menu:
                System.out.println("Please choose 1, 2 or 3");
            }

        } catch (Exception e) {  // if user doesn't enter integer, do this:
            System.out.println("Please choose 1, 2 or 3");
        }

    }

    public static void roomReservation() { // method to run if guest chooses to reserve a room

    }
}



