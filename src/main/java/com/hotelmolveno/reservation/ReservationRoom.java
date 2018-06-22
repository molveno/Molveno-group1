package com.hotelmolveno.reservation;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.user.Guest;
import java.util.HashMap;

public class ReservationRoom {


    private HashMap<Room, Guest> reservationRoomList = new HashMap<Room, Guest>();


    public void setReservationRoomList(Room newRoom, Guest newGuest) {

        reservationRoomList.put(newRoom, newGuest);

    }
}
