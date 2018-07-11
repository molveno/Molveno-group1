package com.hotelmolveno.controller.backend;

import com.hotelmolveno.hotel.Room;
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

        boolean oneGuestFound = false;
        for (Guest guest : newReservation.getGuests()) {
            Optional<Guest> g = this.guestRepository.findById(guest.getGuestID());

            if (g.isPresent()) {
                oneGuestFound = true;
            }

            // should exist

        }

        if (!oneGuestFound) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        boolean oneRoomFound = false;
        for (Room room : newReservation.getRooms()) {
            Optional<Room> r = this.roomRepository.findById(room.getRoomID());

            if (r.isPresent()) {
                oneRoomFound = true;
            }

            // should exist

        }

        if (!oneRoomFound) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        Reservation reservation = new Reservation();
        reservation.setCheckInDate(newReservation.getCheckInDate());
        reservation.setCheckOutDate(newReservation.getCheckOutDate());
        reservation.setComments(newReservation.getComments());

        this.reservationRepository.save(reservation);


        for (Guest guest : newReservation.getGuests()) {
            Optional<Guest> optionalGuest = this.guestRepository.findById(guest.getGuestID());

            if (optionalGuest.isPresent()) {
                Guest foundGuest = optionalGuest.get();
                reservation.add(foundGuest);
                foundGuest.getReservations().add(reservation);

                this.guestRepository.save(foundGuest);

                // should exist

            }
            this.reservationRepository.save(reservation);


        }

        for (Room room : newReservation.getRooms()) {
            Optional<Room> optionalRoom = this.roomRepository.findById(room.getRoomID());

            if (optionalRoom.isPresent()) {
                Room foundRoom = optionalRoom.get();
                reservation.add(foundRoom);
                foundRoom.getReservations().add(reservation);

                this.roomRepository.save(foundRoom);

                // should exist

            }
            this.reservationRepository.save(reservation);


        }

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


            for (Guest guest : input.getGuests()) {

                if (!output.getGuests().contains(guest)) {
                    output.add(guest);
                }
            }

            for (Room room : input.getRooms()) {

                if (!output.getRooms().contains(room)) {
                    output.add(room);
                }
            }

            //op deze manier, als je een roomID invult die niet bestaat, dan pakt hij zelf een nieuwe roomID! je meot dus alleen
            //roomID's gebruiken die bestaan

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



