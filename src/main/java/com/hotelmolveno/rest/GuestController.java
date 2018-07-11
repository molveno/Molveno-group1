package com.hotelmolveno.rest;

import com.hotelmolveno.persistance.GuestRepository;
import com.hotelmolveno.service.GuestService;
import com.hotelmolveno.user.GuestStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
//
//    @Autowired
//    private GuestRepository guestRepository; //link to repository

    @Autowired
    private GuestService guestService;  //link to Service

    @PostMapping
    public GuestStore create(@RequestBody GuestStore newGuest) {
        return this.guestService.create(newGuest);
    }

    @GetMapping
    public Iterable<GuestStore> list() {
        return this.guestService.list();
    }

    @GetMapping("{(id}")
    public GuestStore findByID(@PathVariable int id) {
        return this.guestService.findByID(id);

    }

    @PutMapping(value = ("{id}"))
    public GuestStore updateByID(@PathVariable int id, @RequestBody GuestStore update) {

        return this.guestService.updateByID(id, update);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByID(@PathVariable int id) {
        this.guestService.deleteByID(id);
    }
}