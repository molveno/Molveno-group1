package com.hotelmolveno.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public static List<Room> rooms = new ArrayList<>(); // Right class <Hotel>???? NO!!!! <Room> for list of Rooms

    public static void addRoomToList(Room room) {
        rooms.add(room);
    }
    // public
}


