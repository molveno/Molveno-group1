package com.hotelmolveno.service;

import com.hotelmolveno.persistance.GuestRepository;
import com.hotelmolveno.user.GuestStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Service
@Transactional
public class GuestService {

    @Autowired
    public GuestRepository guestRepository;

    public GuestStore create(GuestStore newGuest) {
        System.out.println(newGuest);
        this.guestRepository.save(newGuest);
        return newGuest;
    }

    public Iterable<GuestStore> list() {
        return this.guestRepository.findAll();

    }

    public GuestStore findByID(int id) {
        GuestStore result = this.guestRepository.findById(id).get();
        return result;
    }

    public GuestStore updateByID(int id, GuestStore update) {
        GuestStore tobeUpdated = this.guestRepository.findById(id).get();
        tobeUpdated.setFirstName(update.getFirstName());
        tobeUpdated.setLastName(update.getLastName());
        tobeUpdated.setAddress(update.getAddress());
        tobeUpdated.setPostalCode(update.getPostalCode());
        tobeUpdated.setCity(update.getCity());
        tobeUpdated.setCountry(update.getCountry());
        tobeUpdated.setTelephoneNumber(update.getTelephoneNumber());
        tobeUpdated.setEmailAddress(update.getEmailAddress());
        return this.guestRepository.save(tobeUpdated);
    }

    public void deleteByID(int id) {

        this.guestRepository.deleteById(id);
    }



}
