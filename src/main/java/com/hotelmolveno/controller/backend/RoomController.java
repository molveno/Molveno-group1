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
    public Collection<Room> list() {
        return this.roomRepository.findAll();
    }

    @GetMapping("{id}")
    public Room findById(@PathVariable int id) {

        Room result = this.roomRepository.findById(id);

        return result;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.roomRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public Room update(@PathVariable int id, @RequestBody Room input) {

        return this.roomRepository.update(id, input);

    }

}