package com.hotelmolveno.reservation;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.user.Guest;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ReservationID;


    private Date checkInDate;
    private Date checkOutDate;
    private String comments;

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

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Guest> guests = new HashSet<>();

    public void add(Guest g) {
        this.guests.add(g);
        g.getReservations().add(this);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();

    public void add(Room r) {
        this.rooms.add(r);
        r.getReservations().add(this);
    }


    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


}

