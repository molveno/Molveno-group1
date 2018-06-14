package com.hotelmolveno.user;

public class Guest {

    private int ID;
    private String firstName;
    private String lastName;
    private long bankNR;

    public Guest(int setID){
        this.ID = setID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
