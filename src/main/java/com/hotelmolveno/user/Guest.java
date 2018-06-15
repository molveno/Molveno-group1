package com.hotelmolveno.user;

public class Guest {

    private int id;
    private String firstName;
    private String lastName;
    private long bankNR;

    public void reserveRoom() {
        
    }

    public Guest(int setID){
        this.id = setID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getBankNR() {
        return bankNR;
    }

    public void setBankNR(long bankNR) {
        this.bankNR = bankNR;
    }
}
