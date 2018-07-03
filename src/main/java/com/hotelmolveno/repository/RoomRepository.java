package com.hotelmolveno.repository;

import com.hotelmolveno.hotel.Room;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RoomRepository {

    // in real live we would have a real DB here .... like Oracle, MySQL or Postgres


    private static int lastId = 0;

    private Map <Integer, Room> rooms = new HashMap<>();  // this you might see as a mock db

    @PostConstruct
    public void addSomeRoomsToGetStarted() {
        for(int i = 0;i<5;i++) {
            Room room = new Room();
            room.setRoomNumber(i);
            room.setReserved(false);

            this.save(room);
        }
    }

    public void save(Room newRoom) {
        newRoom.setRoomID(++lastId);
        this.rooms.put(newRoom.getRoomID(), newRoom);

    }

    public Collection<Room> findAll() {
        return this.rooms.values();
    }

    public Room findById(int id) {

        Room found = this.rooms.get(id);

        return found;
    }

    public void deleteById(int id) {

        this.rooms.remove(id);
    }

    public Room update(int id, Room update) {
        Room victim = this.findById(id);

        victim.setReserved(update.getReserved());
        victim.setRoomNumber(update.getRoomNumber());

        return victim;
    }
}