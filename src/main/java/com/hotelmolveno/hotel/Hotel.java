package com.hotelmolveno.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public static void main(String[] args) {
        Room room = new Room(0);
        System.out.println(room);
        addRoomToList(11);
        System.out.println(rooms);

    }

    public static List<Room> rooms = new ArrayList<>(); // Right class <Hotel>???? NO!!!! <Room> for list of Rooms

    public static void addRoomToList(int roomID) {
        Room room = new Room(roomID);
        rooms.add(room);


    }
}


