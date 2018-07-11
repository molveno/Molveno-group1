package com.hotelmolveno.hotel;

import org.junit.Assert;
import org.junit.Test;

public class RoomTest {

    @Test
    public void testRoomConstructor() {
        Room testRoom = new Room(1, 2, 3);
        Assert.assertEquals(1, testRoom.getRoomNumber());
        Assert.assertEquals(2, testRoom.getCapacity());
        Assert.assertEquals(3, testRoom.getPrice(), 0.001); // to compare floating point numbers, need delta param
    }

    @Test
    public void testGetAndSetRoomNumber() {
        Room testRoom = new Room(2,2,2);
        testRoom.setRoomNumber(1);
        Assert.assertEquals(1, testRoom.getRoomNumber());
    }

    @Test
    public void name() {
    }
}