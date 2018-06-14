package com.hotelmolveno.hotel;

import com.hotelmolveno.hotel.LuxuryRoom;
import com.hotelmolveno.hotel.Room;

public class InheritanceTester {

    public static void main(String[] args) {
        Room room1 = new Room();
        room1.getMainRoomMessage();
        room1.showMessage();

        Room newLuxRoom = new LuxuryRoom(0);
        newLuxRoom.showMessage();



    }

}
