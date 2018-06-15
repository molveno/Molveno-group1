package com.hotelmolveno.hotel;

import java.util.List;

public class Room {
    protected int roomID = 0;
    protected boolean reserved = false;
    protected String employee = "";

    private List guests;

    public Room(){ //main constructor
    }

    public Room(int setRoomID, boolean setReserved){ //second constructor
        this.roomID = setRoomID;
        this.reserved = setReserved;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public List getGuests() {
        return guests;
    }

    public void setGuests(List guests) {
        this.guests = guests;
    }
}

