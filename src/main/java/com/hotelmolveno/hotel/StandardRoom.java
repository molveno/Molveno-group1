package com.hotelmolveno.hotel;

public class StandardRoom extends Room {

private boolean balconyAvailable;

    public StandardRoom(int setRoomID, boolean setReserved, boolean balconyAvailable) {
//        super(0, 4, 100);
        this.balconyAvailable = balconyAvailable;
    }


    public boolean isBalconyAvailable() {
        return balconyAvailable;
    }
    public void setBalconyAvailable(boolean balconyAvailable) {
        this.balconyAvailable = balconyAvailable;
    }
}






//test2

//test3

//test4