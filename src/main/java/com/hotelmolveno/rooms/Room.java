package com.hotelmolveno.rooms;

public class Room {
    protected int roomID = 0;
    protected boolean reserved = false;

    public Room(){
    }

    public Room(int setRoomID, boolean setReserved){
        this.roomID = setRoomID;
        this.reserved = setReserved;
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
}

