package com.hotelmolveno.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelmolveno.reservation.Reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Room implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int roomID; // this field is now the ID (key for DB)

//    protected static int nextRoomID = 0;

    protected int roomNumber;
    protected boolean reserved;
    protected int capacity;
    protected int numberOfGuests;
    protected double price;
    protected String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomID == room.roomID;
    }

    @Override
    public int hashCode() {

        return Objects.hash(roomID);
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    @JsonIgnore
    @ManyToMany(mappedBy="rooms", cascade=CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();


    @Enumerated(EnumType.STRING)
    protected RoomType roomType;



    @Enumerated(EnumType.STRING)
    protected TypeOfBeds bedType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public enum UserType{
        ADMIN, EDITOR, USER;
    }


    public Room() {

    }
//    public static int getNextRoomID() {
//        return nextRoomID;
//    }
//
//    public static void setNextRoomID(int nextRoomID) {
//        Room.nextRoomID = nextRoomID;
//    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Room(int setRoomNumber, int setCapacity, double setPrice) {
//        this.roomID = nextRoomID;
//        nextRoomID++;
        this.roomNumber = setRoomNumber;
        this.capacity = setCapacity;
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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public TypeOfBeds getBedType() {
        return bedType;
    }

    public void setBedType(TypeOfBeds bedType) {
        this.bedType = bedType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID = " + roomID +
                ", roomNumber = " + roomNumber +
                ", reserved = " + reserved +
                ", capacity = " + capacity +
                ", price = " + price +
                '}';
    }
}



