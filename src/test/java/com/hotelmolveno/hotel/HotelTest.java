package com.hotelmolveno.hotel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HotelTest {


    // rooms is a static variable... why??

    @Test
    public void testAddRoomToList() {
        Hotel testHotel = new Hotel();

        Room testRoom = new Room(1,1,1);
        testHotel.addRoomToList(testRoom);

        Assert.assertTrue(testHotel.rooms.contains(testRoom));

    }
}