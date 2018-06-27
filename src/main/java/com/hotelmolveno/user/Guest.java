package com.hotelmolveno.user;

import com.hotelmolveno.App;

import java.lang.reflect.Array;
import java.util.*;

import static com.hotelmolveno.reservation.ReservationRoom.reservationRoomList;

public class Guest extends User {

    public static List<User> userListGuest = new ArrayList<>();    //initiate empty arrayList

    public Guest(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {
        super(firstName, lastName, address, postalCode, city, country, telephoneNumber, emailAddress);  //constructor
    }

    public Guest() {
        super();
    }

    public static void addNewGuest() {
        Scanner addGuest = new Scanner(System.in);
        System.out.println("Adding new user, please provide the firstname: ");
        String firstName = addGuest.nextLine();
        System.out.println("Lastname: ");
        String lastName = addGuest.nextLine();
        System.out.println("Address: ");
        String address = addGuest.nextLine();
        System.out.println("Postalcode: ");
        String postalCode = addGuest.nextLine();
        System.out.println("City: ");
        String city = addGuest.nextLine();
        System.out.println("Country: ");
        String country = addGuest.nextLine();
        System.out.println("Telephone number: ");
        String telephoneNumber = addGuest.nextLine();
        System.out.println("Lastely, enter an e-mail address: ");
        String emailAddress = addGuest.nextLine();

        User newUser = new Guest();
        App.setCounterGuest();
        newUser.setGuestID(App.getCounterGuest());
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);
        newUser.setPostalCode(postalCode);
        newUser.setCity(city);
        newUser.setCountry(country);
        newUser.setTelephoneNumber(telephoneNumber);
        newUser.setEmailAddress(emailAddress);
        userListGuest.add(newUser);
    }


    //initate test users
    public static void addNewGuestInitiate(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {

        User newUser = new Guest();
        App.setCounterGuest();
        newUser.setGuestID(App.getCounterGuest());
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);
        newUser.setPostalCode(postalCode);
        newUser.setCity(city);
        newUser.setCountry(country);
        newUser.setTelephoneNumber(telephoneNumber);
        newUser.setEmailAddress(emailAddress);
        userListGuest.add(newUser);
    }

    public static void initiateTestGuests() {
        Guest.addNewGuestInitiate("Gerard", "Joling", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        Guest.addNewGuestInitiate("Henk", "Crol", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        Guest.addNewGuestInitiate("Joep", "Hek", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        Guest.addNewGuestInitiate("Kees", "Naarling", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        Guest.addNewGuestInitiate("Max", "Stappen", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        Guest.addNewGuestInitiate("Pim", "Wittenberg", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
    }

    public static void getGuestList() {
        for (User listUsers : userListGuest) {
            System.out.println(listUsers);
        }
    }


    public static void delGuestFromList() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter firstname: ");
        String firstName = input.nextLine();

            for(User userRecord : userListGuest) {
            if (userRecord.getFirstName().equals(firstName) == true) {
                System.out.print(userRecord.getFirstName() + "\t Found! ");
                break;
            }
            i++;
        }
        userListGuest.remove(i);
    }

    public static void changeGuestFromList() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter firstname: ");
        String firstName = input.nextLine();

        for(User userRecord : userListGuest) {
            if (userRecord.getFirstName().equals(firstName) == true) {
                User newUser = userRecord;
                System.out.print("\n" + userRecord.getFirstName() + "\t Found! \n");
                Scanner addGuest = new Scanner(System.in);

                System.out.println("Changing new user, please provide the firstname: ");
                String firstName1 = addGuest.nextLine();
                System.out.println("Lastname: ");
                String lastName = addGuest.nextLine();
                System.out.println("Address: ");
                String address = addGuest.nextLine();
                System.out.println("Postalcode: ");
                String postalCode = addGuest.nextLine();

                System.out.println("City: ");
                String city = addGuest.nextLine();
                System.out.println("Country: ");
                String country = addGuest.nextLine();
                System.out.println("Telephone number: ");
                String telephoneNumber = addGuest.nextLine();
                System.out.println("Lastely, enter an e-mail address: ");
                String emailAddress = addGuest.nextLine();

//                User newUser = new Guest();
                //App.setCounterGuest();
                //userRecord.setGuestID(App.getCounterGuest());
                userRecord.setFirstName(firstName1);
                userRecord.setLastName(lastName);
                userRecord.setAddress(address);
                userRecord.setPostalCode(postalCode);
                userRecord.setCity(city);
                userRecord.setCountry(country);
                userRecord.setTelephoneNumber(telephoneNumber);
                userRecord.setEmailAddress(emailAddress);
//                userListGuest.add(newUser);

                System.out.println("\nUser details have been changed");

                break;
            }
            i++;
        }
        userListGuest.remove(i);
    }



    public static void searchGuests(String firstName) {

        for (User myList : userListGuest) {                                                  //ITERATE THROUGH GUEST LIST
            if (myList.getFirstName() == firstName) {
                System.out.print(myList.getFirstName() + "\t User exists. ");
                for (Map.Entry<Integer, Integer> entry : reservationRoomList.entrySet()) {    //ITERATE THROUGH RESERVATION LIST
                    if (entry.getKey() == myList.getGuestID()) {
                        System.out.println("With reservations id: " + entry.getKey());
                    } else {
                        System.out.println("");
                    }

//                        for()
                    break;
                }
            }
        }
    }
}
