package com.hotelmolveno.hotel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int roomID; // this field is now the ID (key for DB)

    protected static int nextRoomID = 0;

    protected int roomNumber;
    protected boolean reserved;
    protected int capacity;
    protected int numberOfGuests;
    protected double price;
    protected String description;

    @Enumerated(EnumType.STRING)
    protected RoomType roomType;

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

    public Room(int setRoomNumber, int setCapacity, double setPrice) {
        this.roomID = nextRoomID;
        nextRoomID++;
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



