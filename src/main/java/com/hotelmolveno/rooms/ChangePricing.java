package com.hotelmolveno.rooms;

public class ChangePricing {
    private int ID = 0;
    private double rate = 0;
    private boolean reserved = false;

    public ChangePricing(int setID, double setRate, boolean setReserved){
        this.ID = setID;
        this.rate = setRate;
        this.reserved = setReserved;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getReservedCustomerID() {
        return reservedCustomerID;
    }

    public void setReservedCustomerID(int reservedCustomerID) {
        this.reservedCustomerID = reservedCustomerID;
    }

    private int reservedCustomerID = 0;
}
