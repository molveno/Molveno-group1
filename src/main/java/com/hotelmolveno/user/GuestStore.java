package com.hotelmolveno.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class GuestStore extends User implements Serializable {
    private int CounterGuest = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int employeeID = 0;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String telephoneNumber;
    private String emailAddress;

    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<User> guests = new ArrayList<>();    //initiate empty arrayList

    public GuestStore(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {
        super(firstName, lastName, address, postalCode, city, country, telephoneNumber, emailAddress);  //constructor
    }

    public GuestStore() {
        super();
    }

    public List<User> getGuestList() {
        return this.guests;
    }

    public void addNewGuest() {
        User user = new GuestStore();
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

        user.setId(getCounterGuestIncrement());
        setCounterGuestIncrement();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setPostalCode(postalCode);
        user.setCity(city);
        user.setCountry(country);
        user.setTelephoneNumber(telephoneNumber);
        user.setEmailAddress(emailAddress);
        guests.add(user);
    }

    private void addNewGuestInitiate(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {
        User user = new GuestStore();
        user.setId(getCounterGuestIncrement());
        setCounterGuestIncrement();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setPostalCode(postalCode);
        user.setCity(city);
        user.setCountry(country);
        user.setTelephoneNumber(telephoneNumber);
        user.setEmailAddress(emailAddress);
        guests.add(user);
    }

    public void initiateTestGuests() {
        addNewGuestInitiate("Valdo", "Smith", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewGuestInitiate("Henk", "Crol", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewGuestInitiate("Joep", "Hek", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewGuestInitiate("Kees", "Naarling", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewGuestInitiate("Max", "Stappen", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewGuestInitiate("Pim", "Wittenberg", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
    }

    public List<User> getGuests() {
        System.out.println("\n----------------------------------------------------------------------------------------------------");

        for (User guests : guests) {
            System.out.println(guests);
        }
        System.out.println("----------------------------------------------------------------------------------------------------");

        return guests;
    }

    public List<User> getGuestsList() {
        return guests;
    }


    public void delGuestFromList() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter firstname: ");
        String firstNameIn = input.nextLine();

        for (User listUsers : getGuestList()) {
            if (listUsers.getFirstName().equals(firstNameIn)) {
                break;
            }
            i++;
        }
        getGuestList().remove(i);
    }

    public void changeGuestFromList() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter firstname: ");
        String firstName = input.nextLine();

        for (User listUsers : getGuestList()) {
            if (listUsers.getFirstName().equals(firstName)) {
                User newUser = listUsers;
                System.out.print("\n" + listUsers.getFirstName() + "\t Found! \n");
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

                listUsers.setFirstName(firstName1);
                listUsers.setLastName(lastName);
                listUsers.setAddress(address);
                listUsers.setPostalCode(postalCode);
                listUsers.setCity(city);
                listUsers.setCountry(country);
                listUsers.setTelephoneNumber(telephoneNumber);
                listUsers.setEmailAddress(emailAddress);
                System.out.println("\nUser details have been changed");

                break;
            }
            i++;
        }
        getGuestList().remove(i);
    }

//    public void searchGuests(String firstName) {
//        for(User listUsers : getEmployeeList()){
//            if (listUsers.getFirstName().equals(firstName)) {
//                System.out.print(listUsers.getFirstName() + "\t User exists. ");
//                for (Map.Entry<Integer, Integer> entry : reservationStore.reservations.entrySet()) {    //ITERATE THROUGH RESERVATION LIST
//                    if (entry.getKey() == listUsers.getId()) {
//                        System.out.println("With reservations id: " + entry.getKey());
//                    } else {
//                        System.out.println("");
//                    }
//                    break;
//                }
//            }
//        }
//    }


    public void guestChanger() {
        final Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter the guest ID number: ");
        int x = reader.nextInt();
        System.out.println("You entered guest ID number " + Integer.toString(x));
        for (User newUser : guests) {
            if (newUser.getId() == x) {
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

                System.out.println(String.valueOf(newUser));
                System.out.println("\n\nSave the following change? [y/n]: ");
                String y = reader.next();
                if (!y.equals("y")) {
                    System.out.println("Restart change process");
                    guestChanger();
                } else {
                    System.out.println("\n\nRecord saved\n\n");
                }
            }
        }
    }

    private int getCounterGuestIncrement() { //getter
        return CounterGuest;
    }

    private void setCounterGuestIncrement() { //setter
        CounterGuest++;
    }


    public int getCounterGuest() {
        return CounterGuest;
    }

    public void setCounterGuest(int counterGuest) {
        CounterGuest = counterGuest;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public long getEmployeeID() {
        return employeeID;
    }

//    @Override
    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
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

    public void setGuests(List<User> guests) {
        this.guests = guests;
    }
}
