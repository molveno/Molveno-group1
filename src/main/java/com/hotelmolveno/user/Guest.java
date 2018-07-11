package com.hotelmolveno.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelmolveno.App;
import com.hotelmolveno.finance.Bill;
import com.hotelmolveno.reservation.Reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

import static com.hotelmolveno.reservation.ReservationRoom.reservationRoomList;

@Entity
public class Guest extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestID;

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String telephoneNumber;
    private String emailAddress;
    private String passportNumber;

    @Override
    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "guests", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy="guest") // person is the private Person instance var in the phone class
    private Set<Bill> bills = new HashSet<>();

    public Set<Bill> getBills() {
        return this.bills;
    }

    public void addBill(Bill bill) {
        this.bills.add(bill);
    }



    @Override
    public int getGuestID() {
        return guestID;
    }

    @Override
    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

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

        for (User userRecord : userListGuest) {
            if (userRecord.getFirstName().equals(firstName)) {
                System.out.print(userRecord.getFirstName() + "\t Found! ");
                break;
            }
            i++;
        }
        userListGuest.remove(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return guestID == guest.guestID;
    }

    @Override
    public int hashCode() {

        return Objects.hash(guestID);
    }

    public static void changeGuestFromList() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter firstname: ");
        String firstName = input.nextLine();

        for (User userRecord : userListGuest) {
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
            if (myList.getFirstName().equals(firstName)) {
                System.out.print(myList.getFirstName() + "\t User exists. ");
                for (Map.Entry<Integer, Integer> entry : reservationRoomList.entrySet()) {    //ITERATE THROUGH RESERVATION LIST
                    if (entry.getKey() == myList.getGuestID()) {
                        System.out.println("With reservations id: " + entry.getKey());
                    } else {
                        System.out.println("");
                    }

                    break;
                }
            }
        }
    }

//    public Reservation getReservation() {
//        return getReservation();
//    }
}


