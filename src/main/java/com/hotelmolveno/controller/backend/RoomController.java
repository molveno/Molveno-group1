package com.hotelmolveno.controller.backend;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room newRoom) {

        this.roomRepository.save(newRoom);

        return new ResponseEntity<Room>(newRoom, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Room>> list() {
        return new ResponseEntity<Iterable<Room>>( this.roomRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Room> findById(@PathVariable int id) {

        Optional<Room> possibleResult = this.roomRepository.findById(id);

        if(possibleResult.isPresent()) {
            Room result = possibleResult.get();
            return new ResponseEntity<Room>(result,HttpStatus.OK);
        } else { return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.roomRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Room> update(@PathVariable int id, @RequestBody Room input) {

        Optional<Room> possibleOutput = this.roomRepository.findById(id);

        if(possibleOutput.isPresent()) {
            Room output = possibleOutput.get();

            output.setRoomNumber(input.getRoomNumber());
            output.setNumberOfGuests(input.getNumberOfGuests());
            output.setPrice(input.getPrice());
            output.setReserved(input.getReserved());

            output = this.roomRepository.save(output);

            return new ResponseEntity<Room>(this.roomRepository.save(output), HttpStatus.OK);

        } else { return new ResponseEntity<Room>(HttpStatus.NOT_FOUND); }


    }

}