package com.hotelmolveno.hotel;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class RoomStore {
    int roomID = 0;


    private List<Room> rooms = new ArrayList<>(); // erooden = set to private, use rooms getter

    public void addRoomToList(Room room) {
        getRooms().add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


    public void defaultRoomMaker() { // method to make a few rooms when initializing the app

        Room a = new Room(0,11, 2, 60.50);
        Room b = new Room(1,12, 2, 60.50);
        Room c = new Room(2,13, 2, 60.50);
        Room d = new Room(3,14, 2, 60.50);
        Room e = new Room(4,15, 2, 60.50);
        Room f = new Room(5,16, 3, 65.50);
        Room g = new Room(6,17, 3, 65.50);
        Room h = new Room(7,18, 3, 65.50);
        Room i = new Room(8,19, 4, 75.50);
        Room j = new Room(9,20, 4, 75.50);
        Room k = new Room(10,21, 4, 75.50);
        Room l = new Room(11,22, 4, 75.50);
        Room m = new Room(12,23, 5, 99.99);
        Room n = new Room(13,24, 5, 99.99);
        Room o = new Room(14,25, 5, 99.99);
        Room p = new Room(15,26, 5, 99.99);
        Room q = new Room(16,27, 8, 120.49);
        Room r = new Room(17,28, 8, 120.49);
        Room s = new Room(18,29, 10, 150.49);
        Room t = new Room(19,30, 12, 180.49);
        Room u = new Room(20,30, 12, 180.49);

        rooms.add(a);
        rooms.add(b);
        rooms.add(c);
        rooms.add(d);
        rooms.add(e);
        rooms.add(f);
        rooms.add(g);
        rooms.add(h);
        rooms.add(i);
        rooms.add(j);
        rooms.add(k);
        rooms.add(l);
        rooms.add(m);
        rooms.add(n);
        rooms.add(o);
        rooms.add(p);
        rooms.add(q);
        rooms.add(r);
        rooms.add(s);
        rooms.add(t);
    }


    public void roomMaker() { // method to run if employee chooses to make a room
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a room number: ");
        int chosenRoomNumber = reader.nextInt();
        System.out.println("You entered room number " + Integer.toString(chosenRoomNumber));
//        boolean roomAlreadyExists = roomNumberCheck(chosenRoomNumber);

//        if (roomAlreadyExists) {
//            roomMaker();
//        }

        System.out.println("How many guests fit in the room? ");
        int roomCapacity = reader.nextInt();
        System.out.println("The capacity of the room is " + Integer.toString(roomCapacity));

        System.out.println("What is the price of the room? (use comma) ");
        double roomPrice = reader.nextDouble();
        System.out.println("The price of the room is " + Double.toString(roomPrice));
        System.out.println("\nHow many days to book the room? (use comma): ");
        double reservationPeriodInput = reader.nextDouble();
        System.out.println("\nEnter the starting date of the booking e.g. [30-6-2018]: ");

        Room room = new Room(roomID, chosenRoomNumber, roomCapacity, roomPrice);
        roomID++;
        room.setRoomNumber(chosenRoomNumber);
        room.setNumberOfGuests(roomCapacity);
        room.setPrice(roomPrice);
        room.setReserved(false);
        room.setReservationPeriodHr(reservationPeriodInput);
        System.out.println(room);
        addRoomToList(room);
    }

    public void roomChanger() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("Enter the room number: ");
        int x = reader.nextInt();
        System.out.println("You entered room number " + Integer.toString(x));

        RoomStore molveno = new RoomStore();
        for (Room r : molveno.getRooms()) {

            if (r.getRoomNumber() == x) {
                System.out.println("A room with room number " + x + " exists");
                System.out.println(r);
                System.out.println("What is the new price of the room? (use comma) ");
                double roomPrice = reader.nextDouble();
                System.out.println("The new price of the room is " + Double.toString(roomPrice));
                r.setPrice(roomPrice);
                System.out.println(r);
            }
        }
    }

    public void roomPrinter() {
        Calendar cal = Calendar.getInstance();
        Date x = cal.getTime();
        double diff;
        final int SECOND = 1000;        // no. of ms in a second
        final int MINUTE = SECOND * 60; // no. of ms in a minute
        final int HOUR = MINUTE * 60;   // no. of ms in an hour
        final int DAY = HOUR * 24;      // no. of ms in a day
        final int WEEK = DAY * 7;       // no. of ms in a week
        System.out.println("\n----------------------------------------------------------------------------------------------------");
        for (Room r : rooms) {
            Date y = r.getReservationStartDate();
            diff = ChronoUnit.MILLIS.between(x.toInstant(), y.toInstant());
            int weeks = (int) (diff / WEEK);
            int days = (int) ((diff % WEEK) / DAY);
            int hours = (int) ((diff % DAY) / HOUR);
            int minutes = (int) ((diff % HOUR) / MINUTE);
            int seconds = (int) ((diff % MINUTE) / SECOND);
            if (!r.getReserved()) {
                System.out.println("Available:\t" + r);
            } else if (days > 1 && days < 7 && weeks == 0) {
                System.out.print("\nLimited (Available now for: " + (days) + " days):\t\t" + r + "\n");
            } else if (weeks >= 1 && weeks < 2) {
                System.out.print("\nshort-Term bookable: (Available now for: " + (weeks) + " week(s), " + (days) + " days):\t\t" + r + "\n");
            } else if (days >= 2 && days < 3) {
                System.out.print("\nMid-Term bookable: (Available now for: " + (weeks) + " week(s), " + (days) + " days):\t\t" + r + "\n");
//            } else if (days >= 18 && days < 90) {
            } else {
                System.out.print("\nLong-Term bookable: (Available now for: " + (weeks) + " week(s), " + (days) + " days):\t\t" + r + "\n");
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

//    private boolean roomNumberCheck(int roomNumber) {
//        for (Room r : roomStore.getRooms()) {
//            if (r.getRoomNumber() == roomNumber) {
//                System.out.println("A room with room number " + roomNumber + " already exists");
//                System.out.println(r);
//                return true;
//            }
//        }
//        return false;
//    }

//    public void checkRoomISBooked() {
//        for (Room r : roomStore.getRooms()) {
//            if (!r.getReserved())
//                System.out.println(r);
//        }
//    }

    public void removeOrAlterRoom(int roomID, int removeOrAlter) {
        Scanner x = new Scanner(System.in);
        boolean delete = false;
        int roomIDSto = 0;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1);     //CHECK-IN DATE TO DEFAULT\\
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        for (Room r : rooms) {
            if (r.getRoomID() == roomID) {
                System.out.println("Room with number: " + r.getRoomNumber() + " and ID: " + r.getRoomID() + " Found.");

                switch (removeOrAlter) {
                    case 0:
                        System.out.println("Continue defaulting the room detail information? [y/n]");
                        if (x.next().equals("y")) {
                            r.setReserved(false);
                            r.setReservationPeriodHr(0);
                            r.setReservationStartDate(cal.getTime());
                            r.setReservationEndDate(cal.getTime());
                            System.out.println("\nRoom details set to default!\n");
                        } else {
                        }
                        break;
                    case 1:
                        System.out.println("Continue DELETING the entire room ?? [yes/no]");
                        if (x.next().equals("yes")) {
                            delete = true;
                            roomIDSto = roomID;
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        if (delete) {
            System.out.println("Room " + rooms.get(roomIDSto).getRoomNumber() + "removed!");
            rooms.remove(roomIDSto);
        }
    }
}


//}


