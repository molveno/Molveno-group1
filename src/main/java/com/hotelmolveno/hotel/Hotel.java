package com.hotelmolveno.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public List<Room> rooms = new ArrayList<>(); // erooden = set to private, use rooms getter

    public void addRoomToList(Room room) {
        rooms.add(room);
    }

    // public
}


