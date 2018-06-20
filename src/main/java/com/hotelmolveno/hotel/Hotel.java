package com.hotelmolveno.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    List<Room> rooms = new ArrayList<>(); // Right class <Hotel>???? NO!!!! <Room> for list of Rooms

    public void addRoomToList() {
        Room room = new Room(0, false);
        rooms.add(room);

    }
}


