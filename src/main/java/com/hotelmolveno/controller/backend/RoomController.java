package com.hotelmolveno.controller.backend;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @PostMapping
    public Room create(@RequestBody Room newRoom) {

        this.roomRepository.save(newRoom);

        return newRoom;
    }

    @GetMapping
    public Iterable<Room> list() {
        return this.roomRepository.findAll();
    }

    @GetMapping("{id}")
    public Room findById(@PathVariable int id) {

        Room result = this.roomRepository.findById(id).get();

        return result;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.roomRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public Room update(@PathVariable int id, @RequestBody Room input) {

        Room output = this.roomRepository.findById(id).get();

//        output.setRoomID(input.getRoomID());
        output.setRoomNumber(input.getRoomNumber());
        output.setNumberOfGuests(input.getNumberOfGuests());
        output.setPrice(input.getPrice());
        output.setReserved(input.getReserved());


        return this.roomRepository.save(output);

    }

}