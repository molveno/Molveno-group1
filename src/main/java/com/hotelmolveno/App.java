package com.hotelmolveno;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.reservation.ReservationRoom;
import com.hotelmolveno.user.Employee;
import com.hotelmolveno.user.Guest;

import static com.hotelmolveno.hotel.Hotel.addRoomToList;
import static com.hotelmolveno.hotel.Hotel.rooms;

// is this now on release branch?

public class App{

    public static void main(String[]args){
//    Room newRoom = new Room( 0, 4, 100.0);
//    newRoom.setReserved(true);
//    System.out.println(newRoom.getRoomID());

        Employee.addNewUser("Dave", "Davidson", "Camblesteet","583492","New York", "US", "+13958543284","dave@gmail.com");
        Employee.addNewUser("Alex", "Davidson", "Camblesteet","583492","New York", "US", "+13958543284","alex@gmail.com");
        Employee.addNewUser("Jack", "Davidson", "Camblesteet","583492","New York", "US", "+13958543284","jack@gmail.com");
        Employee.addNewUser("Steve", "Davidson", "Camblesteet","583492","New York", "US", "+13958543284","steve@gmail.com");
        Guest.addNewUser("Gerard", "Joling", "Camblesteet","583492","New York", "US", "+13958543284","steve@gmail.com");

        Room a = new Room(11, 2, 99.99);
        Room b = new Room(12, 2, 99.99);
        Room c = new Room(13, 2, 99.99);
        Room d = new Room(14, 2, 99.99);

        rooms.add(a);
        rooms.add(b);
        rooms.add(c);
        rooms.add(d);

        Guest.getUsers();







        ReservationRoom reservation = new ReservationRoom();



















































//
//    public static final ImpossibleToDevideByZeroException e = new ImpossibleToDevideByZeroException();
//
//    public static void main(String[]args) throws ImpossibleToDevideByZeroException {
//
//    public static CalculateResult calculateNumbers(int a, int b){
//        System.out.println("FOUND ERROR");
//        CalculateResult c = new CalculateResult();
//        try{
//            c.result = a/b;
//        }
//
//        catch(ArithmeticException e){
//            c.e = new ImpossibleToDevideByZeroException();
//        }
//        return c;
//    }
//}
//
//class CalculateResult {
//    int result;
//    Exception e;
//
//    @Override
//    public String toString() {
//        return "CalculateResult{" +
//                "result=" + result +
//                '}';
//    }
//}
