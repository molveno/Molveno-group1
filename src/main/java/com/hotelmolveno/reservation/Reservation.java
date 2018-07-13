package com.hotelmolveno.reservation;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.user.Guest;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ReservationID;
    private boolean checkInStatus;


    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String comments;

    public boolean isCheckInStatus() {
        return checkInStatus;
    }

    public void setCheckInStatus(boolean checkInStatus) {
        this.checkInStatus = checkInStatus;
    }

    public long getReservationID() {
        return ReservationID;
    }

    public void setReservationID(long reservationID) {
        ReservationID = reservationID;
    }

    public String getComments() {
        return comments;
    }



    public void setComments(String comments) {
        this.comments = comments;
    }


    public Set<Guest> getGuests() {
        return guests;
    }

    public String getAllGuestsByFirstNameAndLastName() {

       Set<String> almostDone = this.getGuests().stream()
               .map(g -> g.getGuestFirstAndLastName())
               .collect(Collectors.toSet());

       return String.join(", ", almostDone);
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public String getAllRoomsByRoomNumber() {

        Set<String> almostDone = this.getRooms().stream()
                .map(r -> String.valueOf(r.getRoomNumber()))
                .collect(Collectors.toSet());

        return String.join(", ", almostDone);
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Guest> guests = new HashSet<>();

    public void add(Guest g) {
        this.guests.add(g);
        g.getReservations().add(this);
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Room> rooms = new HashSet<>();

    public void add(Room r) {
        this.rooms.add(r);
        r.getReservations().add(this);
    }


    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


}

