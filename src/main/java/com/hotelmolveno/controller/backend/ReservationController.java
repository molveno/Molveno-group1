package com.hotelmolveno.controller.backend;

import com.hotelmolveno.repository.GuestRepository;
import com.hotelmolveno.repository.ReservationRepository;
import com.hotelmolveno.repository.RoomRepository;
import com.hotelmolveno.reservation.Reservation;
import com.hotelmolveno.user.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {


    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation newReservation) {

        // first ... add logic to find the eventually existing Guests in the reservation by the id of guest

        boolean oneFound = false;
        for(Guest guest: newReservation.getGuests()){
            Optional<Guest> g = this.guestRepository.findById(guest.getGuestID());

            if (g.isPresent()){
                oneFound = true;
            }

            // should exist

        }

        if(!oneFound) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



        Reservation reservation = new Reservation();
        reservation.setCheckInDate(newReservation.getCheckInDate());
        reservation.setCheckOutDate(newReservation.getCheckOutDate());
        reservation.setComments(newReservation.getComments());

        this.reservationRepository.save(reservation);


        for(Guest guest: newReservation.getGuests()){
           Guest g = this.guestRepository.findById(guest.getGuestID()).get();

           reservation.add(g);
           g.getReservations().add(reservation);

           this.guestRepository.save(g);

           // should exist

        }
        this.reservationRepository.save(reservation);

        return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Reservation>> list() {
        return new ResponseEntity<Iterable<Reservation>>(this.reservationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> findById(@PathVariable long id) {

        Optional<Reservation> possibleResult = this.reservationRepository.findById(id);

        if (possibleResult.isPresent()) {
            Reservation result = possibleResult.get();
            return new ResponseEntity<Reservation>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        this.reservationRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Reservation> update(@PathVariable long id, @RequestBody Reservation input) {

        Optional<Reservation> possibleOutput = this.reservationRepository.findById(id);

        if (possibleOutput.isPresent()) {
            Reservation output = possibleOutput.get();


            for (Guest guest : input.getGuests()){

                if(!output.getGuests().contains(guest)) {
                    output.add(guest);
                }
            }

            output.setCheckInDate(input.getCheckInDate());
            output.setCheckOutDate(input.getCheckOutDate());
            output.setComments(input.getComments());


            output = this.reservationRepository.save(output);

            return new ResponseEntity<Reservation>(this.reservationRepository.save(output), HttpStatus.OK);

        } else {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
    }
}


