package com.hotelmolveno.hotel;

import com.hotelmolveno.reservation.Reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int roomID; // this field is now the ID (key for DB)

    protected static int nextRoomID = 0;

    protected int roomNumber;
    protected boolean reserved;
    protected int numberOfGuests;
    protected double price;


    public Set<Reservation> getReservations() {
        return reservations;
    }

    @ManyToMany(mappedBy="rooms", cascade=CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();


    public Room() {

    }

    public Room(int setRoomNumber, int setNumberOfGuests, double setPrice) {
        this.roomID = nextRoomID;
        nextRoomID++;
        this.roomNumber = setRoomNumber;
        this.numberOfGuests = setNumberOfGuests;
        this.price = setPrice;
        // this.reserved = setReserved; // add later
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void showMessage() {
        System.out.println("Welcome to your base room");
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }


    public void getMainRoomMessage() {
        System.out.println("Message from main room");
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfGuests() {
        return this.numberOfGuests;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID = " + roomID +
                ", roomNumber = " + roomNumber +
                ", reserved = " + reserved +
                ", numberOfGuests = " + numberOfGuests +
                ", price = " + price +
                '}';
    }
}



