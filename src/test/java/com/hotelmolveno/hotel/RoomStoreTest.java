package com.hotelmolveno.hotel;

import org.junit.Assert;
import org.junit.Test;

public class RoomStoreTest {


    // rooms is a static variable... why??

    @Test
    public void testAddRoomToList() {
        RoomStore testRoomStore = new RoomStore();

        Room testRoom = new Room(0,1,1, 99);
        testRoomStore.addRoomToList(testRoom);

        Assert.assertTrue(testRoomStore.getRooms().contains(testRoom));

    }
}