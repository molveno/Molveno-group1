package com.hotelmolveno.hotel;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class Room {
    private int roomID = 0;
    private int roomNumber = 11;
    private boolean reserved;
    private int numberOfGuests;
    private double price;
    private double reservationPeriodHr;
    private Date reservationStartDate;  //date of new booking\\
    private Date reservationEndDate;    //end = startDate + PeriodHr\\

    public Room(int roomID, int setRoomNumber, int setNumberOfGuests, double setPrice) {
        this.roomID = roomID;
        this.roomNumber = setRoomNumber;
        this.numberOfGuests = setNumberOfGuests;
        this.price = setPrice;
        reservationPeriodHr = 0;
        Calendar cal1 = Calendar.getInstance();
        cal1.getTime();
        cal1.set(Calendar.YEAR,1);
        cal1.set(Calendar.MONTH,0);
        cal1.set(Calendar.DAY_OF_MONTH,0);
        cal1.set(Calendar.HOUR_OF_DAY,0);
        cal1.set(Calendar.MINUTE,0);
        cal1.set(Calendar.SECOND,0);
        reservationEndDate = cal1.getTime();
        reservationStartDate = cal1.getTime();
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
        Calendar cal = Calendar.getInstance();
        Date x = cal.getTime();
        Date y = reservationStartDate;
        double diff;
        final int SECOND = 1000;        // no. of ms in a second
        final int MINUTE = SECOND * 60; // no. of ms in a minute
        final int HOUR = MINUTE * 60;   // no. of ms in an hour
        final int DAY = HOUR * 24;      // no. of ms in a day
        final int WEEK = DAY * 7;       // no. of ms in a week
        diff = ChronoUnit.MILLIS.between(x.toInstant(), y.toInstant());
        int days = (int) ((diff % WEEK) / DAY);

        if(reserved != true) {
            return "Room {" +
                    "id:" + roomID +
                    ", NR: " + roomNumber +
                    ", " + numberOfGuests + " person room" +
                    '}';
        }else{
            return "\n\t\t\tRoom {" +
                    "id:" + roomID +
                    ", NR: " + roomNumber +
//                  ", reserved = " + reserved +
                    ", " + numberOfGuests + " person room" +
                    ", Period: " + reservationPeriodHr/24 +
                    ", \n\t\t\tSTART: " + reservationStartDate +
                    ", END: " + reservationEndDate +
                    ", Available after: " + getCalcTime() +
                    '}' + "\n";
        }
    }

    public String getCalcTime() {
        double remaining;
        Calendar cal = Calendar.getInstance();
        Date newDate = cal.getTime();
        Date resDate = reservationEndDate;

        remaining = ChronoUnit.MILLIS.between(newDate.toInstant(), resDate.toInstant());

        final int SECOND = 1000;        // no. of ms in a second
        final int MINUTE = SECOND * 60; // no. of ms in a minute
        final int HOUR = MINUTE * 60;   // no. of ms in an hour
        final int DAY = HOUR * 24;      // no. of ms in a day
        final int WEEK = DAY * 7;       // no. of ms in a week

        int weeks = (int) (remaining / WEEK);
        int days = (int) ((remaining % WEEK) / DAY);
        int hours = (int) ((remaining % DAY) / HOUR);
        int minutes = (int) ((remaining % HOUR) / MINUTE);
        int seconds = (int) ((remaining % MINUTE) / SECOND);

        String ret = ("weeks:" + weeks + " days:" +days + " [" +hours + ":" +minutes + ":" +seconds+"]");

        return (ret);
    }

    public void setReservationPeriodHr(double reservationPeriodInput) {
        reservationPeriodHr = reservationPeriodInput;
    }

    public Date getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationStartDate(Date newCal1) {
        reservationStartDate = newCal1;
    }

    public void setReservationEndDate(Date newCal2) {
        reservationEndDate = newCal2;
    }

    public Date getReservationStartDate() {
        return reservationStartDate;
    }

    public double getReservationPeriod() {
        return reservationPeriodHr;
    }
}
