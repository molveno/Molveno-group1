package com.hotelmolveno.hotel;
/*
import java.util.Scanner;

public class PriceOfRoom {

    private double LuxuryRoom;
    private double BudgetRoom;
    private double StandardRoom;


    { private String getPriceOfLuxeryRoom;  //getter
        return public void setPriceOfLuxeryRoom;
}}

public class RoomMakerApp {

    static boolean state = true;

    public static void main(String[] args)  {
        while(state) {
            printMenu();
        }
    }

    public static void printMenu() {
        System.out.println("1. Give the budgetprice in the lower season");
        System.out.println("2. Quit");
        userChoice();
    }

    public static void userChoice() {

        try {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("What's the budgetprice in the lower season? ");
            int x = reader.nextInt();
//once finished
            // reader.close();
            System.out.println("User input was " + Integer.toString(x));

            switch (x) {
                case 1:
                    System.out.println("You choose to set the price");
                    roomMaker();
                    break; //
                case 2:
                    System.out.println("You choose to quit");
                    state = false;
                    break;
            }

            if (x > 2 || x < 1) { // if user enters a number not in the menu:
                System.out.println("Please choose 1 of 2");
            }

        } catch (Exception e) {  // if user doesn't enter integer, do this:
            System.out.println("Please choose a number");
        }

    }

    public static void roomMaker() { // method to run if employee chooses to make a room
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("Give the price for the budgetroom in the lowerseason ");
        double x = reader.nextInt();
        System.out.println("You entered the budget price " + double.toString(x));

        System.out.println("Do you want the price for a BudgetRoom? It's the price you filled in. Or do you want us to calculate de the for the Standard Room or LuxeryRoom? ");
        int chosenRoomNumber = reader.nextInt();
        System.out.println("You entered room number " + Integer.toString(chosenRoomNumber));

        System.out.println("How many guests fit in the room? ");
        int roomCapacity = reader.nextInt();
        System.out.println("The capacity of the room is " + Integer.toString(roomCapacity));

        Room room = new Room(x, chosenRoomNumber, roomCapacity);
        room.setRoomID(x);
        room.setRoomNumber(chosenRoomNumber);
        room.setNumberOfGuests(roomCapacity);
        System.out.println(room);
        addRoomToList(room);
        System.out.println(rooms);


        Formules:
        BudgetRoom LowerSeason = int BudLo
        StandardRoom LowerSeason = BudLo + BudLo/5
        LuxeryRoom LowerSeason = BudLo + BudLo/4
        BudgetRoom HigherSeason = BudLo + BudLo/5
        StandardRoom HigherSeason = BudLo + BudLo/4
        LuxeryRoom HigherSeason = BudLo + BudLo/3

        
        */

