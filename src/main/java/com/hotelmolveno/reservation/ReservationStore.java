package com.hotelmolveno.reservation;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.hotel.RoomStore;
import com.hotelmolveno.user.GuestStore;
import com.hotelmolveno.user.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ReservationStore {

    public Map<Integer, Integer> reservations = new HashMap<>();

    int counterReservation = 0;

    public int getCounterReservation() { //getter
        return counterReservation;
    }

    public void setCounterReservation() { //setter
        this.counterReservation++;
    }

    public void setReservationRoomList(int roomID, int userID) {
        reservations.put(roomID, userID);
        setCounterReservation();
    }

    public void initiateTestReservations(RoomStore roomStore, GuestStore guestStore) {
        List<Room> rooms = roomStore.getRooms();
        List<User> users = guestStore.getGuestList();
        Calendar cal1 = Calendar.getInstance();
        cal1.getTime();
        cal1.add(Calendar.DAY_OF_MONTH, 7);
        Date x = cal1.getTime();
        Calendar cal2 = Calendar.getInstance();
        cal2.getTime();
        rooms.get(0).setReservationPeriodHr((8 * 24));
        cal2.add(Calendar.DAY_OF_MONTH, (7 + 8));
        cal2.set(Calendar.HOUR_OF_DAY, 13);
        cal2.set(Calendar.MINUTE, 0);
        Date y = cal2.getTime();
        rooms.get(0).setReservationStartDate(x);
        rooms.get(0).setReservationEndDate(y);
        rooms.get(0).setReserved(true);
        setReservationRoomList(rooms.get(0).getRoomID(), users.get(0).getId());

        Calendar cal3 = Calendar.getInstance();
        cal3.getTime();
        cal3.add(Calendar.DAY_OF_MONTH, 14);
        Date x2 = cal3.getTime();
        Calendar cal4 = Calendar.getInstance();
        cal4.getTime();
        rooms.get(5).setReservationPeriodHr((14 * 24));
        cal4.add(Calendar.DAY_OF_MONTH, (14 + 14));
        cal4.set(Calendar.HOUR_OF_DAY, 13);
        cal4.set(Calendar.MINUTE, 0);
        Date y2 = cal4.getTime();
        rooms.get(5).setReservationStartDate(x2);
        rooms.get(5).setReservationEndDate(y2);
        rooms.get(5).setReserved(true);
        setReservationRoomList(rooms.get(5).getRoomID(), users.get(5).getId());


//NEED-FIX
    }

    public void addToReservationRoomList(RoomStore roomStore, GuestStore guestStore) {
        List<Room> rooms = roomStore.getRooms();
        List<User> users = guestStore.getGuests();

        Scanner newUser = new Scanner(System.in);
        RoomStore roomStore1 = new RoomStore();
        System.out.println("Available rooms: ");
        int maxRooms = 0;
        int firstRN = 0;
        int lastRN = 0;
        boolean first = false;

        for (Room r : rooms) {
            maxRooms++;
            if (!r.getReserved()) {
                if (!first) {
                    first = true;
                    firstRN = r.getRoomNumber();
                }
                System.out.println("Room number: " + r.getRoomNumber() + " | persons: " + r.getNumberOfGuests() + " | " + "price: € " + r.getPrice());
                lastRN = r.getRoomNumber();
            }
        }
        maxRooms--;
        System.out.print("\nEnter available room number [" + firstRN + "-" + lastRN + "]: ");

        int roomNR = newUser.nextInt();
        roomNR:
        while (roomNR <= firstRN || roomNR >= lastRN) {
            if (roomNR >= firstRN && roomNR <= lastRN) {
                break roomNR;
            } else {
                System.out.println("Invalid input");
                System.out.print("\nEnter available room number [" + firstRN + "-" + lastRN + "]: ");
                roomNR = newUser.nextInt();
            }
        }

        int roomID = 0;
        roomID:
        for (Room x : rooms) {
            if (x.getRoomNumber() == roomNR) {
                roomID = x.getRoomID();
                break roomID;
            }
        }

        whenAvailable:
        for (Room x : rooms) {
            if (rooms.get(roomID).getReserved()) {
                System.out.println("\n----------------------------------------------------------------------------------------------------");
                System.out.println("Room is not available, select other room id.");
                System.out.println("----------------------------------------------------------------------------------------------------");
                this.addToReservationRoomList(roomStore1, guestStore);
            } else {
                if (true) {

                    int maxGuest = 0;
                    for (User g : users) {
                        maxGuest++;
                    }
                    maxGuest--;

                    System.out.print("enter guestID: [1-" + maxGuest + "]: ");
                    int guestID = newUser.nextInt();
                    guestID:
                    while (guestID <= 0 || guestID >= maxGuest) {
                        if (guestID >= 0 && guestID <= maxGuest) {
                            break guestID;
                        } else {
                            System.out.println("Invalid input");
                            System.out.print("enter guestID: [1-" + maxGuest + "]: ");
                            guestID = newUser.nextInt();
                        }
                    }

                    for (User myList : users) { //CHECK IF GUEST ALREADY HAS CURRENTLY A RESERVATION
                        if (myList.getId() == guestID) {
                            for (Map.Entry<Integer, Integer> entry : reservations.entrySet()) {                          //ITERATE THROUGH RESERVATION LIST key=room value=guest
                                if (entry.getValue() == guestID) {
                                    System.out.print("Warning, this user already has a reservation. ");
                                    System.out.println("Room number: " + rooms.get(entry.getKey()).getRoomNumber() + ". Room ID: " + rooms.get(entry.getKey()).getRoomID());
                                    System.out.println("Abort? [y/n]: ");
                                    if (newUser.next().equals("y")) {
                                        System.out.println("Abort!");
                                        break whenAvailable;

                                    } else {
                                    }
                                    break;
                                }
                            }
                        }
                    }


                    System.out.print("enter period in days: [1-365]: ");
                    double bookingPeriod = newUser.nextInt();
                    bookID:
                    while (bookingPeriod < 1 || bookingPeriod > 365) {
                        if (bookingPeriod >= 1 && bookingPeriod <= 365) {
                            break bookID;
                        } else {
                            System.out.println("Invalid input");
                            System.out.print("enter  period in days: [1-365]: ");
                            bookingPeriod = newUser.nextInt();
                        }
                    }
                    Calendar cal = getNewDate();     //USER TIME METHOD
                    Date startDate1 = cal.getTime();
                    rooms.get(roomID).setReservationStartDate(startDate1);      //SET START DATE
                    cal.add(Calendar.HOUR_OF_DAY, (int) (bookingPeriod * 24));
                    cal.set(Calendar.HOUR_OF_DAY, 13);
                    cal.set(Calendar.MINUTE, 00);
                    cal.set(Calendar.SECOND, 00);
                    Date startDate2 = cal.getTime();
                    rooms.get(roomID).setReservationEndDate(startDate2);        //SET END DATE

                    setReservationRoomList(rooms.get(roomID).getRoomID(), users.get(guestID).getId());   //CREATE RESERVATION

                    rooms.get(roomID).setReservationPeriodHr(bookingPeriod);    //SET PERIOD

                    System.out.println("\nStart date: " + startDate1);
                    System.out.println("End date: \t" + startDate2);
                    rooms.get(roomID).setReserved(true);                        //SET TO BOOKED
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    System.out.println("\nReservation created for: " + users.get(guestID).getFirstName() + " " + users.get(guestID).getLastName() + " with room number: " + rooms.get(roomID).getRoomNumber() + ". BookingPeriod: " + bookingPeriod + " days.\n");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
                } else {
                    System.out.println("Room is unavailable, try again with available room.");
                    break whenAvailable;
                }
            }
        }
    }

    //    public void getReservationRoomList(List<Room> room, List<User> user) {
    public void getReservationRoomList(RoomStore roomStore, GuestStore guestStore) {
        List<Room> rooms = roomStore.getRooms();
        List<User> users = guestStore.getGuestList();
        int c = 0, d = 0;
        System.out.println("\n----------------------------------------------------------------------------------------------------");
        for (Map.Entry<Integer, Integer> entry : reservations.entrySet()) {                          //ITERATE THROUGH RESERVATION LIST key=room value=guest
            int key = Integer.valueOf(entry.getKey());                                                      //SET KEY FROM RESERVATION LIST
            int value = Integer.valueOf(entry.getValue());                                                  //SET VALUE FROM RESERVATION LIST

            for (Room myRoomList : rooms) {
                if (key == rooms.get(c).getRoomID()) {                                                    //CHECK IF KEY EXISTS IN ROOM ARRAY (roomsID), IF SO, ROOM IS BOOKED
                    System.out.print("Room Number: " + String.valueOf(rooms.get(c).getRoomNumber() + " (" + rooms.get(c).getRoomID() + ")"));

                    for (User myGuestList : users) {                                                    //ITERATE THROUGH GUEST LIST
                        if (value == users.get(d).getId()) {                                       //CHECK IF VALUE EXISTS IN GUEST ARRAY (guestID),  IF SO, PRINT GUEST NAME
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
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public void delReservationFromRoomList(RoomStore roomStore, GuestStore guestStore) {
        List<Room> rooms = roomStore.getRooms();
        List<User> users = guestStore.getGuests();

        System.out.println("Which guest reservation would you like to delete? [firstname]: ");
        Scanner delGuest = new Scanner(System.in);
        String firstName = delGuest.next();
        int c = 0, d = 0;

        Iterator it = reservations.entrySet().iterator();                                                //ITERATE THROUGH RESERVATION LIST key=room value=guest
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int key = (int) pair.getKey();                                                                      //SET KEY FROM RESERVATION LIST
            int value = (int) pair.getValue();                                                                  //SET VALUE FROM RESERVATION LIST

            for (Room myRoomList : rooms) {
                if (key == rooms.get(c).getRoomID()) {                                                           //CHECK IF KEY EXISTS IN ROOM ARRAY (roomID), IF SO, ROOM IS BOOKED
                    rooms.get(c).setReserved(false);
                    rooms.get(c).setReservationPeriodHr(0);
                    for (User myGuestList : users) {                                                     //ITERATE THROUGH GUEST LIST
                        if (value == users.get(d).getId()) {                                        //CHECK IF VALUE EXISTS IN GUEST ARRAY (guestID),  IF SO, PRINT GUEST NAME
                            System.out.println(" reserved by: " + myGuestList.getFirstName());
                            if (users.get(d).getFirstName().equals(firstName)) {
                                System.out.println(firstName + " found, continue altering record... \n");
                                it.remove();    //REMOVING RESERVATION
                                roomStore.removeOrAlterRoom(key, 0); //DEFAULTING ROOM DETAILS
                                System.out.println("Reservation for " + firstName + " removed");
                            } else {
                                System.out.println("----------------------------------------------------------------------------------------------------");
                                System.out.println("GuestStore not found.");
                                System.out.println("----------------------------------------------------------------------------------------------------");
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

    //    public void alterReservationFromRoomList(List<Room> rooms, List<User> users) {
    public void alterReservationFromRoomList(RoomStore roomStore, GuestStore guestStore) {
        List<Room> rooms = roomStore.getRooms();
        List<User> users = guestStore.getGuests();
        int a = 0;
        boolean e = false;
        this.getReservationRoomList(roomStore, guestStore);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which guest reservation would you like to alter? [firstname]: ");
        String firstName = scanner.nextLine();

        Iterator it = reservations.entrySet().iterator();                                                //ITERATE THROUGH RESERVATION LIST key=room value=guest
        start:
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int key = (int) pair.getKey();                                                                      //SET KEY FROM RESERVATION LIST
            int value = (int) pair.getValue();                                                                  //SET VALUE FROM RESERVATION LIST

            for (Room myRoomList : rooms) {     //ITERATE ROOM\\
                if (key == myRoomList.getRoomID()) {    ////|FIND OLD ROOM|\\\\                               //CHECK IF ROOM-KEY EXISTS IN ROOM ARRAY
                    for (User myGuestList : users)      //ITERATE GUEST\\
                        if (value == myGuestList.getId()) {////FIND OLD-GUEST\\\\                 //CHECK IF GUEST-VALUE EXISTS IN GUEST ARRAY
//CHECK IF RESERVATION EXISTS\\
                            if (users.get(value).getFirstName().equals(firstName)) {
                                System.out.println("Reservation nr: " + value + " found for guest: " + firstName + "\n");
                                System.out.println("1. assign new user to existing room");
                                System.out.println("2. assign new room to existing user");
                                System.out.print("Choose an on of the options below: ");
                                int menu = scanner.nextInt();
                                switch (menu) {
                                    case 1:
                                        guestStore.getGuests();
                                        System.out.println("Enter guest ID: ");
                                        int guestIDNew = scanner.nextInt();
                                        reservations.put(key, guestIDNew);
                                        System.out.println("assigned new user to new room");
                                        this.getReservationRoomList(roomStore, guestStore);
                                        break;
                                    case 2:
                                        roomStore.roomPrinter();
//CHOOSE NEW ROOM\\
                                        System.out.println("Enter Room ID: ");  //roomALTER-IN
                                        int roomIDNew = scanner.nextInt();

                                        for (Room r : rooms) {      //LIST ALL ROOMS\\
                                            if (!r.getReserved()) {
                                            }
                                        }
                                        for (Room x : rooms) {      //ITERATE ROOM\\
//CHECK IF NEW CHOSEN ROOM IS AVAILABLE\\
                                            if (rooms.get(roomIDNew).getReserved()) {
                                                System.out.println("Room is not available, select other room id.");
                                                break start; //GOTO BEGIN\\
                                            } else {
                                                if (true) {
                                                    guestStore.getGuests();
                                                    for (User myList : users) {//ITERATE GUEST\\                                                        //CHECK IF GUEST ALREADY HAS A RESERVATION
                                                        if (myList.getId() == value) {                                                                     ///FIND OLD ROOM\\\
                                                            for (Map.Entry<Integer, Integer> entry : reservations.entrySet()) {//ITERATE THROUGH RESERVATION LIST (key=room value=guest)
//CHECK IF USER ALREADY HAS A RESERVATION
                                                                if (entry.getValue() == value) {
                                                                    System.out.print("Warning, this user already has a reservation. ");
                                                                    System.out.println("Room number: " + rooms.get(entry.getKey()).getRoomNumber() + ". Room ID: " + rooms.get(entry.getKey()).getRoomID());
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    Date dateStart1 = rooms.get(key).getReservationStartDate();
                                                    Date dateEnd1 = rooms.get(key).getReservationEndDate();
                                                    double datePeriod = rooms.get(key).getReservationPeriod();
                                                    rooms.get(roomIDNew).setReservationStartDate(dateStart1);
                                                    rooms.get(roomIDNew).setReservationEndDate(dateEnd1);
                                                    rooms.get(roomIDNew).setReservationPeriodHr(datePeriod);
                                                    rooms.get(roomIDNew).setReserved(true);

                                                    setReservationRoomList(rooms.get(roomIDNew).getRoomID(), users.get(value).getId());
                                                    this.setRoomToDefault(key, rooms);

                                                    a = key;
                                                    e = true;

                                                    break start;
                                                } else {
                                                    System.out.println("Room is unavailable, try again");
                                                }
                                            }
                                        }
                                        System.out.println("assigned new room to existing room");
                                }
                                System.out.println(firstName + " booked on room: " + pair.getValue());
                            } else {
                                System.out.println("\n----------------------------------------------------------------------------------------------------");
                                System.out.println("User not found");
                                System.out.println("----------------------------------------------------------------------------------------------------");
                                break;
                            }
                        } else {
//                            System.out.println("GuestStore not found.");
                        }
                } else {
//                    System.out.println("Room not found.");
                }
            }
        }
        System.out.println("value of key a is: " + a);

        if (e) {

            Iterator it2 = reservations.entrySet().iterator();                                                //ITERATE THROUGH RESERVATION LIST key=room value=guest
            while (it2.hasNext()) {
                Map.Entry pair = (Map.Entry) it2.next();
                int key = (int) pair.getKey();                                                                      //SET KEY FROM RESERVATION LIST
                if (key == a) {
                    it2.remove();
                    System.out.println("Old room ID: " + a + "is removed");
                    break;
                }
            }
        }
    }


    public Calendar getCalcTime(Calendar getCal) {
        long remaining = -1;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = getCal;
        remaining = ChronoUnit.MILLIS.between(cal1.toInstant(), cal2.toInstant());

        final int SECOND = 1000;        // no. of ms in a second
        final int MINUTE = SECOND * 60; // no. of ms in a minute
        final int HOUR = MINUTE * 60;   // no. of ms in an hour
        final int DAY = HOUR * 24;      // no. of ms in a day
        final int WEEK = DAY * 7;       // no. of ms in a week

        System.out.println("Remaining: " + remaining);
        int weeks = (int) (remaining / WEEK);
        int days = (int) ((remaining % WEEK) / DAY);
        int hours = (int) ((remaining % DAY) / HOUR);
        int minutes = (int) ((remaining % HOUR) / MINUTE);
        int seconds = (int) ((remaining % MINUTE) / SECOND);

        System.out.println("weeks:" + weeks + " days:" + days + " [" + hours + ":" + minutes + ":" + seconds + "]");

        return cal1;
    }

    private Calendar getNewDate() {
        Scanner newInput = new Scanner(System.in);
        System.out.print("Enter year [e.g. 2018/2025]: ");
        int year = newInput.nextInt();
        bookYear:
        while (year < 2018 || year > 2025) {
            if (year >= 2018 && year <= 2025) {
                break bookYear;
            } else {
                System.out.println("Invalid input");
                System.out.print("Enter year [2018/2025]: ");
                year = newInput.nextInt();
            }
        }

        System.out.print("Enter month, e.g. (1:January | 6:June | 12:December) [1/12]: ");
        int month = newInput.nextInt();
        bookMonth:
        while (month < 1 || month > 12) {
            if (month >= 1 && month <= 12) {
                break bookMonth;
            } else {
                System.out.println("Invalid input");
                System.out.print("Enter month [1/12]: ");
                month = newInput.nextInt();
            }
        }
        month--;

        System.out.print("Enter day, e.g. [1-31]: ");
        int day = newInput.nextInt();
        bookDay:
        while (day < 1 || day > 31) {
            if (day >= 1 && day <= 31) {
                break bookDay;
            } else {
                System.out.println("Invalid input");
                System.out.print("Enter day [1-31]: ");
                day = newInput.nextInt();
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        try {
            Date date = sdf.parse("Sun Jul 1 16:02:37 GMT 2018");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = sdf.getCalendar();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.getTime();

        return cal;
    }

    private void setRoomToDefault(int roomNR, List<Room> rooms) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        for (Room x : rooms) {
            if (roomNR == x.getRoomID()) {
                x.setReserved(false);
                x.setReservationPeriodHr(0);
                x.setReservationStartDate(cal.getTime());
                x.setReservationEndDate(cal.getTime());
                break;
            }
        }
    }
}