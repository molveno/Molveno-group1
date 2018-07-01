package com.hotelmolveno.user;

import com.hotelmolveno.App;

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
        System.out.print("Adding new user, please provide the firstname: ");
        String firstName = addGuest.nextLine();
        System.out.print("Lastname: ");
        String lastName = addGuest.nextLine();
        System.out.print("Address: ");
        String address = addGuest.nextLine();
        System.out.print("Postalcode: ");
        String postalCode = addGuest.nextLine();
        System.out.print("City: ");
        String city = addGuest.nextLine();
        System.out.print("Country: ");
        String country = addGuest.nextLine();
        System.out.print("Telephone number: ");
        String telephoneNumber = addGuest.nextLine();
        System.out.print("Lastely, enter an e-mail address: ");
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
        App.setCounterGuest();
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
        String firstNameIn = input.nextLine();

        for (User userRecord : userListGuest) {
            if (userRecord.getFirstName().equals(firstNameIn) == true) {
                System.out.print(userRecord.getFirstName() + "\t Found! ");
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


    public static void guestChanger() {
        final Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter the guest ID number: ");
        int x = reader.nextInt();
        System.out.println("You entered guest ID number " + Integer.toString(x));
        for (User newUser : userListGuest) {
            if (newUser.getGuestID() == x) {
                System.out.println("A guest with ID number " + x + " exists. Adujsting user, please provide");
                System.out.print("Firstname: ");
                String firstName = reader.next();
                System.out.print("Lastname: ");
                String lastName = reader.next();
                System.out.print("Address: ");
                String address = reader.next();
                System.out.print("Postalcode: ");
                String postalCode = reader.next();
                System.out.print("City: ");
                String city = reader.next();
                System.out.print("Country: ");
                String country = reader.next();
                System.out.print("Telephone number: ");
                String telephoneNumber = reader.next();
                System.out.print("Lastely, enter an e-mail address: ");
                String emailAddress = reader.next();

                newUser.setFirstName(firstName);
                newUser.setLastName(lastName);
                newUser.setAddress(address);
                newUser.setPostalCode(postalCode);
                newUser.setCity(city);
                newUser.setCountry(country);
                newUser.setTelephoneNumber(telephoneNumber);
                newUser.setEmailAddress(emailAddress);

                System.out.printf(String.valueOf(newUser));
                System.out.println("\n\nSave the following change? [y/n]: ");
                String y = reader.next();
                if (y.equals("y") != true) {
                    System.out.println("Restart change process");
                    Guest.guestChanger();
                }else{
                System.out.println("\n\nRecord saved\n\n");
                }
            }
        }
    }
}
