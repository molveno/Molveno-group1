package com.hotelmolveno.reservation;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.user.Guest;

import java.io.Serializable;
import java.util.Set;

public class ReservationModel implements Serializable {

    private Iterable<Reservation> reservations;

    private Iterable<Room> rooms;

    private Iterable<Guest> guests;

    public Iterable<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Iterable<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Iterable<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Iterable<Room> rooms) {
        this.rooms = rooms;
    }

    public Iterable<Guest> getGuests() {
        return guests;
    }

    public void setGuests(Iterable<Guest> guests) {
        this.guests = guests;
    }
}
