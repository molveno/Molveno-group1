package com.hotelmolveno.hotel;

public class Room {
    protected int roomID = 0;
    protected boolean reserved = false;
    //protected String message = "";

    public Room(){
    }

    public Room(int setRoomID, boolean setReserved){
        this.roomID = setRoomID;
        this.reserved = setReserved;
    }


    public void showMessage(){
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


    public void getMainRoomMessage(){
        System.out.println("Message from main room");
    }


}

