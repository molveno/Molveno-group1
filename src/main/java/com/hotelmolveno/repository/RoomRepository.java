package com.hotelmolveno.repository;

import com.hotelmolveno.hotel.Room;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RoomRepository {


    private static int counter = 0;
    private Map<Integer, Room> rooms = new HashMap<>();

    public Iterable<Room> findAll() {
        Iterable<Room> result = this.rooms.values();

        return result;
    }

    public Room save(Room roomToBeSaved) {

        counter++;
        this.rooms.put(counter, roomToBeSaved);
        roomToBeSaved.setRoomID(counter);
        Room savedRoom = this.rooms.get(counter);

        return savedRoom;
    }

    public Room update(int id, Room input) {

        Room output = this.rooms.get(id);

        output.setRoomID(input.getRoomID());
        output.setRoomNumber(input.getRoomNumber());
        output.setNumberOfGuests(input.getNumberOfGuests());
        output.setPrice(input.getPrice());

        // and so on ... if you have more fields

        return output;
    }

    public void delete(int id) {
        this.rooms.remove(id);
    }

    public Room findById(int id) {

        Room result = this.rooms.get(id);
        return result;
    }
}