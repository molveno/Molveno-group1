package com.hotelmolveno.reservation;

import com.hotelmolveno.App;
import com.hotelmolveno.hotel.Hotel;
import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.hotel.RoomMakerApp;
import com.hotelmolveno.user.Guest;
import com.hotelmolveno.user.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static com.hotelmolveno.user.Guest.userListGuest;

public class ReservationRoom {

    public static Map<Integer, Integer> reservationRoomList = new HashMap<>();

    public static void setReservationRoomList(int roomID, int userID) {
        reservationRoomList.put(roomID, userID);
        App.setCounterReservation();
//        System.out.println("reservation added" + App.getCounterReservation());
    }

    public static void initiateTestReservations() {
        Hotel Hotel = new Hotel();

        ReservationRoom.setReservationRoomList(Hotel.rooms.get(0).getRoomID(), Guest.userListGuest.get(0).getGuestID());
        ReservationRoom.setReservationRoomList(Hotel.rooms.get(1).getRoomID(), Guest.userListGuest.get(1).getGuestID());
        ReservationRoom.setReservationRoomList(Hotel.rooms.get(2).getRoomID(), Guest.userListGuest.get(2).getGuestID());
        ReservationRoom.setReservationRoomList(Hotel.rooms.get(3).getRoomID(), Guest.userListGuest.get(3).getGuestID());
        ReservationRoom.setReservationRoomList(Hotel.rooms.get(4).getRoomID(), Guest.userListGuest.get(4).getGuestID());
        ReservationRoom.setReservationRoomList(Hotel.rooms.get(5).getRoomID(), Guest.userListGuest.get(5).getGuestID());
//        ReservationRoom.setReservationRoomList(new Integer(Hotel.rooms.get(5).getRoomID()), new Integer(Guest.userListGuest.get(5).getGuestID()));            //CURRENTLY NOT USED AT ALL\\
//        ReservationRoom.setReservationRoomList(new Integer(Hotel.rooms.get(0).getRoomID()), new Integer(Employee.userListEmployee.get(0).getEmployeeID()));
//        ReservationRoom.setReservationRoomList(new Integer(Hotel.rooms.get(1).getRoomID()), new Integer(Employee.userListEmployee.get(1).getEmployeeID()));
//        ReservationRoom.setReservationRoomList(new Integer(Hotel.rooms.get(2).getRoomID()), new Integer(Employee.userListEmployee.get(2).getEmployeeID()));
//        System.out.println("roomID: " + new Integer(Hotel.rooms.get(0).getRoomID()) + " userID: " + new Integer(Employee.userListEmployee.get(0).getEmployeeID()) + " " + userListEmployee.get(0).getFirstName());
    }

    public static void addToReservationRoomList() {
        Scanner newUser = new Scanner(System.in);
        Guest.getGuestList();
        RoomMakerApp roomMakerApp = new RoomMakerApp();
        roomMakerApp.roomPrinter();
        System.out.print("\nAdding Reservation, enter roomID:[1-100] ");
        int roomID = newUser.nextInt();
        System.out.print("enter guestID: ");
        int guestID = newUser.nextInt();

        Hotel hotel = new Hotel();
        ReservationRoom.setReservationRoomList(hotel.rooms.get(roomID).getRoomID(), Guest.userListGuest.get(guestID).getGuestID());
    }

    public void getReservationRoomList() {
        Hotel Hotel = new Hotel();

        int c = 0, d = 0;
        System.out.println("");
        for (Map.Entry<Integer, Integer> entry : reservationRoomList.entrySet()) {                          //ITERATE THROUGH RESERVATION LIST
            int key = Integer.valueOf(entry.getKey());                                                      //SET KEY FROM RESERVATION LIST
            int value = Integer.valueOf(entry.getValue());                                                  //SET VALUE FROM RESERVATION LIST
//            System.out.print("## " + reservationRoomList + "|" + key + "_" + value + " roomID:" + Hotel.rooms.get(c).getRoomID() +"|" +" ##\t");

            for (Room myRoomList : Hotel.rooms) {
                if (key == Hotel.rooms.get(c).getRoomID()) {                                                    //CHECK IF KEY EXISTS IN ROOM ARRAY (roomID), IF SO, ROOM IS BOOKED
                    System.out.print("Room Number: " + String.valueOf(Hotel.rooms.get(c).getRoomNumber() + " (" + Hotel.rooms.get(c).getRoomID() + ")"));

                    for (User myGuestList : userListGuest) {                                                    //ITERATE THROUGH GUEST LIST
                        if (value == userListGuest.get(d).getGuestID()) {                                       //CHECK IF VALUE EXISTS IN GUEST ARRAY (guestID),  IF SO, PRINT GUEST NAME
                            System.out.println(" reserved by: " + myGuestList.getFirstName());
                            break;
                        }
                        d++;
                    }
                    d = 0;
                }
                c++;
            }
            c = 0;
        }
    }//

    public static void delReservationFromRoomList() {
        Guest.getGuestList();
        System.out.println("Which guest would you like to delete? [firstname]: ");
        Scanner delGuest = new Scanner(System.in);
        String firstName = delGuest.nextLine();
        Scanner userInput = new Scanner(System.in);
        int c = 0, d = 0;
        System.out.println("");

        Iterator it = reservationRoomList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int key = (int) pair.getKey();                                                                      //SET KEY FROM RESERVATION LIST
            int value = (int) pair.getValue();                                                                   //SET VALUE FROM RESERVATION LIST

            Hotel hotel = new Hotel();
            for (Room myRoomList : hotel.rooms) {
                if (key == hotel.rooms.get(c).getRoomID()) {                                                    //CHECK IF KEY EXISTS IN ROOM ARRAY (roomID), IF SO, ROOM IS BOOKED

                    for (User myGuestList : userListGuest) {                                                    //ITERATE THROUGH GUEST LIST
                        if (value == userListGuest.get(d).getGuestID()) {                                       //CHECK IF VALUE EXISTS IN GUEST ARRAY (guestID),  IF SO, PRINT GUEST NAME
//                            System.out.println(" reserved by: " + myGuestList.getFirstName());
                            if (userListGuest.get(d).getFirstName().equals(firstName)) {
                                System.out.println(firstName + " found, continue deleting recored? [y/n]: ");
                                String x = userInput.nextLine();
                                if (x.equals("y")) {
                                    it.remove();
                                    System.out.println(firstName + " removed");
                                }
                            }
                            break;
                        }
                        d++;
                    }
                    d = 0;
                }
                c++;
            }
            c = 0;
        }
    }
}