////package com.hotelmolveno.hotel;
////
////import java.time.temporal.ChronoUnit;
////import java.util.Scanner;
////
/////*
////This app enables the user to make, alter and view rooms, guests & reservations in the console
//// */
////import java.util.*;
////
////public class RoomMaker {
////
//////    public void defaultRoomMaker(List<Room> roomList) { // method to make a few rooms when initializing the app
//////        Room a = new Room(11, 2, 60.50);
//////        Room b = new Room(12, 2, 60.50);
//////        Room c = new Room(13, 2, 60.50);
//////        Room d = new Room(14, 2, 60.50);
//////        Room e = new Room(15, 2, 60.50);
//////        Room f = new Room(16, 3, 65.50);
//////        Room g = new Room(17, 3, 65.50);
//////        Room h = new Room(18, 3, 65.50);
//////        Room i = new Room(19, 4, 75.50);
//////        Room j = new Room(20, 4, 75.50);
//////        Room k = new Room(21, 4, 75.50);
//////        Room l = new Room(22, 4, 75.50);
//////        Room m = new Room(23, 5, 99.99);
//////        Room n = new Room(24, 5, 99.99);
//////        Room o = new Room(25, 5, 99.99);
//////        Room p = new Room(26, 5, 99.99);
//////        Room q = new Room(27, 8, 120.49);
//////        Room r = new Room(28, 8, 120.49);
//////        Room s = new Room(29, 10, 150.49);
//////        Room t = new Room(30, 12, 180.49);
//////
//////
//////        roomList.add(a);
//////        roomList.add(b);
//////        roomList.add(c);
//////        roomList.add(d);
//////        roomList.add(e);
//////        roomList.add(f);
//////        roomList.add(g);
//////        roomList.add(h);
//////        roomList.add(i);
//////        roomList.add(j);
//////        roomList.add(k);
//////        roomList.add(l);
//////        roomList.add(m);
//////        roomList.add(n);
//////        roomList.add(o);
//////        roomList.add(p);
//////        roomList.add(q);
//////        roomList.add(r);
//////        roomList.add(s);
//////        roomList.add(t);
//////        System.out.println("RoomListMaker: " + roomList);
//////    }
////
////
////
////    private void roomChanger() {
////        Scanner reader = new Scanner(System.in);  // Reading from System.in
////
////        System.out.println("Enter the room number: ");
////        int x = reader.nextInt();
////        System.out.println("You entered room number " + Integer.toString(x));
////
////        RoomStore molveno = new RoomStore();
////        for (Room r : molveno.getRooms()) {
////
////            if (r.getRoomNumber() == x) {
////                System.out.println("A room with room number " + x + " exists");
////                System.out.println(r);
////                System.out.println("What is the new price of the room? (use comma) ");
////                double roomPrice = reader.nextDouble();
////                System.out.println("The new price of the room is " + Double.toString(roomPrice));
////                r.setPrice(roomPrice);
////                System.out.println(r);
////            }
////        }
////    }
////
////
////
//////    private boolean roomNumberCheck(int roomNumber) {
//////        for (Room r : roomStore.getRooms()) {
//////            if (r.getRoomNumber() == roomNumber) {
//////                System.out.println("A room with room number " + roomNumber + " already exists");
//////                System.out.println(r);
//////                return true;
//////            }
//////        }
//////        return false;
//////    }
//////
//////    public void checkRoomISBooked() {
//////        for (Room r : roomStore.getRooms()) {
//////            if (!r.getReserved())
//////                System.out.println(r);
//////        }
//////    }
////
////    public void removeOrAlterRoom(int roomID, int removeOrAlter) {
////        Scanner x = new Scanner(System.in);
////        boolean delete = false;
////        int roomIDSto = 0;
//////        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
////        Calendar cal = Calendar.getInstance();
////        cal.set(Calendar.YEAR, 1);     //CHECK-IN DATE TO DEFAULT\\
////        cal.set(Calendar.MONTH, 0);
////        cal.set(Calendar.DAY_OF_MONTH, 0);
////        cal.set(Calendar.HOUR_OF_DAY, 0);
////        cal.set(Calendar.MINUTE, 0);
////        cal.set(Calendar.SECOND, 0);
////
//////        for (Room r : roomStore.getRooms()) {
//////            if (r.getRoomID() == roomID) {
//////                System.out.println("Room with number: " + r.getRoomNumber() + " and ID: " + r.getRoomID() + " Found.");
//////
//////                switch (removeOrAlter) {
//////                    case 0:
//////                        System.out.println("Continue defaulting the room detail information? [y/n]");
//////                        if (x.next().equals("y")) {
//////                            r.setReserved(false);
//////                            r.setReservationPeriodHr(0);
//////                            r.setReservationStartDate(cal.getTime());
//////                            r.setReservationEndDate(cal.getTime());
//////                            System.out.println("\nRoom details set to default!\n");
//////                        } else {
//////                        }
//////                        break;
//////                    case 1:
//////                        System.out.println("Continue DELETING the entire room ?? [yes/no]");
//////                        if (x.next().equals("yes")) {
//////                            delete = true;
//////                            roomIDSto = roomID;
//////                            break;
//////                        }
//////                    default:
//////                        break;
//////                }
//////            }
//////        }
//////        if (delete) {
//////            System.out.println("Room " + roomStore.getRooms().get(roomIDSto).getRoomNumber() + "removed!");
//////            roomStore.getRooms().remove(roomIDSto);
//////        }
////    }
////}
////
////
////