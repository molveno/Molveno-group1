package com.hotelmolveno;

import com.hotelmolveno.hotel.RoomMakerApp;

public class App {
    private static int counterGuest = 0;
    private static int counterEmployee = 0;
    private static int counterReservation = 0;

    public static void main(String[]args){
        RoomMakerApp.main(null);                   //######### LOAD MAIN PROGRAM #########\\


    }//end-of-main

    public static int getCounterGuest() {
        return counterGuest;
    }

    public static void setCounterGuest() {
        App.counterGuest++;
    }

    public static int getCounterEmployee() {
        return counterEmployee;
    }

    public static void setCounterEmployee() {
        App.counterEmployee++;
    }

    public static int getCounterReservation() {
        return counterReservation;
    }

    public static void setCounterReservation() {
        App.counterReservation++;
    }
}//end-of-app


//  EXCEPTION SAMPLE CODE  \\
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
