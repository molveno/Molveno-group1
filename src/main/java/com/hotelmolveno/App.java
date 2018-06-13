package com.hotelmolveno;

import com.hotelmolveno.rooms.Guest;
import com.hotelmolveno.rooms.LuxuryRoom;
import com.hotelmolveno.rooms.Room;

/**
 * Molveno World Program!
 *
 */
public class App{
    public static void main(String[] args){

       int RoomCount = 20;

       /*Guest[] newGuest = new Guest[3];*/
        Guest newGuest = new Guest(0);
       /* for(int i = 0; i < RoomCount; i++){
            newGuest[i] = new Guest(i);

        }*/

        //newGuest[0] = new Guest(0);
        //newGuest[1] = new Guest(1);
        //newGuest[2] = new Guest(2);

        newGuest.setID(5);

        System.out.println(newGuest.getID());
        //System.out.println(newGuest[0].getID());
        //System.out.println(newGuest[1].getID());
        //System.out.println(newGuest[2].getID());
    }
}
