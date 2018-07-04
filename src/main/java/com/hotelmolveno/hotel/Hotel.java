package com.hotelmolveno.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public List<Room> rooms = new ArrayList<>(); // erooden = set to private, use rooms getter

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoomToList(Room room) {
        rooms.add(room);
    }
    // public
}


