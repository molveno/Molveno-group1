package com.hotelmolveno;

import com.hotelmolveno.hotel.Room;

public class App{

    public static void main(String[]args){
    Room newRoom = new Room();
    newRoom.setReserved(true);
    System.out.println(newRoom.getRoomID());

       }
}

