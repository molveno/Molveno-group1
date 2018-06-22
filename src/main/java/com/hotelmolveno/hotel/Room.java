package com.hotelmolveno.hotel;

import java.util.List;

public class Room {
    protected int roomID = 0;
    protected boolean reserved = false;
    protected int numberOfGuests;
    //protected String message = "";

    private List guests;

    public Room(int setRoomID) {
        this.roomID = setRoomID;
        // this.reserved = setReserved; // add later
    }

    public Room() {

    }

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
                ", reserved=" + reserved +
                ", numberOfGuests=" + numberOfGuests +
                '}';
    }
}

