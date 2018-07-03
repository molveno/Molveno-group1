package com.hotelmolveno.user;

import java.util.*;

public class EmployeeStore extends User {
    private int CounterEmployee = 0;

    private List<User> employees = new ArrayList<>();    //initiate empty arrayList

    public EmployeeStore(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {
        super(firstName, lastName, address, postalCode, city, country, telephoneNumber, emailAddress);  //constructor
    }

    public EmployeeStore() {
        super();
    }

    public void getEmployeeList() {
        for(User users : employees){
            System.out.println(users);
        }
//        return employees;
    }

    public void addNewEmployee() {
        User user = new EmployeeStore();
        Scanner addEmployee = new Scanner(System.in);
        System.out.print("Adding new user, please provide the firstname: ");
        String firstName = addEmployee.nextLine();
        System.out.print("Lastname: ");
        String lastName = addEmployee.nextLine();
        System.out.print("Address: ");
        String address = addEmployee.nextLine();
        System.out.print("Postalcode: ");
        String postalCode = addEmployee.nextLine();
        System.out.print("City: ");
        String city = addEmployee.nextLine();
        System.out.print("Country: ");
        String country = addEmployee.nextLine();
        System.out.print("Telephone number: ");
        String telephoneNumber = addEmployee.nextLine();
        System.out.print("Lastely, enter an e-mail address: ");
        String emailAddress = addEmployee.nextLine();

        user.setEmployeeID(getCounterEmployeeIncrement());
        setCounterEmployeeIncrement();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setPostalCode(postalCode);
        user.setCity(city);
        user.setCountry(country);
        user.setTelephoneNumber(telephoneNumber);
        user.setEmailAddress(emailAddress);
        employees.add(user);
    }

    private void addNewEmployeeInitiate(String firstName, String lastName, String address, String postalCode, String city, String country, String telephoneNumber, String emailAddress) {
        User user = new EmployeeStore();
        user.setEmployeeID(getCounterEmployeeIncrement());
        setCounterEmployeeIncrement();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setPostalCode(postalCode);
        user.setCity(city);
        user.setCountry(country);
        user.setTelephoneNumber(telephoneNumber);
        user.setEmailAddress(emailAddress);
        employees.add(user);
    }

    public void initiateTestEmployee() {
        addNewEmployeeInitiate("Adam", "Baker", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewEmployeeInitiate("Clark", "Davis", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewEmployeeInitiate("Evan", "Franks", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewEmployeeInitiate("Irwin", "Hills", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewEmployeeInitiate("Mason", "Sopez", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
        addNewEmployeeInitiate("Peter", "Quinn", "Camblesteet", "583492", "New York", "US", "+13958543284", "steve@gmail.com");
    }

    public List<User> getEmployees() {
        for(User employees : employees){
            System.out.println(employees);
        }
        return employees;
    }


    public void delEmployeeFromList() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter firstname: ");
        String firstNameIn = input.nextLine();

        for(User listUsers : getEmployees()){
            if (listUsers.getFirstName().equals(firstNameIn)) {
                break;
            }
            i++;
        }
        getEmployees().remove(i);
    }

    public void changeEmployeeFromList() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter firstname: ");
        String firstName = input.nextLine();

        for(User listUsers : getEmployees()){
            if (listUsers.getFirstName().equals(firstName)) {
                User newUser = listUsers;
                System.out.print("\n" + listUsers.getFirstName() + "\t Found! \n");
                Scanner addEmployee = new Scanner(System.in);

                System.out.println("Changing new user, please provide the firstname: ");
                String firstName1 = addEmployee.nextLine();
                System.out.println("Lastname: ");
                String lastName = addEmployee.nextLine();
                System.out.println("Address: ");
                String address = addEmployee.nextLine();
                System.out.println("Postalcode: ");
                String postalCode = addEmployee.nextLine();

                System.out.println("City: ");
                String city = addEmployee.nextLine();
                System.out.println("Country: ");
                String country = addEmployee.nextLine();
                System.out.println("Telephone number: ");
                String telephoneNumber = addEmployee.nextLine();
                System.out.println("Lastely, enter an e-mail address: ");
                String emailAddress = addEmployee.nextLine();

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
        getEmployees().remove(i);
    }

    public void employeeChanger() {
        final Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter the employees ID number: ");
        int x = reader.nextInt();
        System.out.println("You entered employees ID number " + Integer.toString(x));
        for (User newUser : employees) {
            if(newUser.getEmployeeID() == x) {
                System.out.println("A employees with ID number " + x + " exists. Adujsting user, please provide");
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
                    employeeChanger();
                } else {
                    System.out.println("\n\nRecord saved\n\n");
                }
            }
        }
    }

    public int getCounterEmployeeIncrement() { //getter
        return CounterEmployee;
    }

    public void setCounterEmployeeIncrement() { //setter
        CounterEmployee++;
    }


}
