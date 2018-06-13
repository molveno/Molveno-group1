package com.hotelmolveno.rooms;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuestTest {

    //Guest myguest = new Guest();
    private Guest guest;

    @Before
    public void setup(){
        this.guest = new Guest(0);
    }

    @Test
    public void testSetID(){
        this.guest.setID(5);
        Assert.assertEquals(5, guest.getID());
    }






}
