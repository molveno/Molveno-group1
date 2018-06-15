package com.hotelmolveno;

import com.hotelmolveno.hotel.Room;

public class App{

    public static void main(String[]args){
    Room newRoom = new Room();

        newRoom.setRoomID(0);
        newRoom.setReserved(true);
        newRoom.setEmployee("pino");

        System.out.println(newRoom.getRoomID());
        System.out.println(newRoom.getEmployee());
        System.out.println(newRoom.getGuests());

       }
}

