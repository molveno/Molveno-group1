package com.hotelmolveno.hotel;

import java.util.List;

public class Room {
    protected int roomID;
    protected int roomNumber;
    protected boolean reserved;
    protected int numberOfGuests;
    protected double price;

    public Room(int setRoomID, int roomNumber, int numberOfGuests, double price) {
        this.roomID = setRoomID;
        // this.reserved = setReserved; // add later
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private List guests;



    public void showMessage() {
        System.out.println("Welcome to your base room");
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }


    public void getMainRoomMessage() {
        System.out.println("Message from main room");
    }


    public void setGuests(List guests) {
        this.guests = guests;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID=" + roomID +
                ", roomNumber=" + roomNumber +
                ", reserved=" + reserved +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                '}';
    }
}



