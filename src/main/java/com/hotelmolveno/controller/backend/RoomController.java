package com.hotelmolveno.controller.backend;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/persons")
public class RoomController {


    @Value("${roomNumber}")
    private int number;


    @Autowired
    private RoomRepository roomRepository;




    @GetMapping
    public Iterable<Room> findAll() {

        final boolean demo = false;

        Iterable<Room> rooms = this.roomRepository.findAll();

        if (demo) {
            for (Room r : rooms) {
                r.setRoomNumber(this.number);
            }
        }


        return rooms;
    }

    @GetMapping(value = "{id}")
    public Room findById(@PathVariable int id) {
        return this.roomRepository.findById(id);
    }

    @PutMapping(value = "{id}")
    public Room update(@PathVariable int id, @RequestBody Room input) {

        return this.roomRepository.update(id, input);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.roomRepository.delete(id);
    }

    @PostMapping
    public Room save(@RequestBody Room room) {

        return this.roomRepository.save(room);
    }
}
