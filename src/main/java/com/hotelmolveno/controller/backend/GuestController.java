package com.hotelmolveno.controller.backend;


import com.hotelmolveno.repository.GuestRepository;
import com.hotelmolveno.repository.RoomRepository;
import com.hotelmolveno.user.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;


    @PostMapping
    public ResponseEntity<Guest> create(@RequestBody Guest newGuest) {

        this.guestRepository.save(newGuest);

        return new ResponseEntity<Guest>(newGuest, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Guest>> list() {
        return new ResponseEntity<Iterable<Guest>>( this.guestRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Guest> findById(@PathVariable int id) {

        Optional<Guest> possibleResult = this.guestRepository.findById(id);

        if(possibleResult.isPresent()) {
            Guest result = possibleResult.get();
            return new ResponseEntity<Guest>(result,HttpStatus.OK);
        } else { return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.guestRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Guest> update(@PathVariable int id, @RequestBody Guest input) {

        Optional<Guest> possibleOutput = this.guestRepository.findById(id);

        if(possibleOutput.isPresent()) {
            Guest output = possibleOutput.get();

            output.setAddress(input.getAddress());
            output.setCity(input.getCity());
            output.setCountry(input.getCountry());
            output.setEmailAddress(input.getEmailAddress());
            output.setFirstName(input.getFirstName());
            output.setLastName(input.getLastName());
            output.setPostalCode(input.getPostalCode());
            output.setTelephoneNumber(input.getTelephoneNumber());
            output.setPassportNumber(input.getPassportNumber());

            output = this.guestRepository.save(output);

            return new ResponseEntity<Guest>(this.guestRepository.save(output), HttpStatus.OK);

        } else { return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND); }


    }

}