package com.hotelmolveno.hotel;


public class InheritanceTester {

    public static void main(String[] args) {
        Room room1 = new Room(0, 4, 100.0);
        room1.getMainRoomMessage();
        room1.showMessage();

        Room newLuxRoom = new LuxuryRoom(0);
        newLuxRoom.showMessage();



    }

}
