package com.hotelmolveno.hotel;

public class StandardRoom extends Room {

private boolean balconyAvailable;

    public StandardRoom(int setRoomID, boolean setReserved, boolean balconyAvailable) {
        super(setRoomID, setReserved);
        this.balconyAvailable = balconyAvailable;
    }


    public boolean isBalconyAvailable() {
        return balconyAvailable;
    }
    public void setBalconyAvailable(boolean balconyAvailable) {
        this.balconyAvailable = balconyAvailable;
    }
}






