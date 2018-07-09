package com.hotelmolveno.reservation;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.user.Guest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Reservation implements Serializable {


    private Date checkInDate;
    private Date checkOutDate;


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

