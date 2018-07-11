package com.hotelmolveno.rest;

import com.hotelmolveno.persistance.GuestRepository;
import com.hotelmolveno.user.GuestStore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class GuestControllerTest {

    @InjectMocks
    private GuestController controller;

    @Mock
    private GuestRepository guestRepository;                    //ONLY IN TESTS

    @Test
    public void testCreate() {

        // setup / pre action // mockit
        GuestStore mock = new GuestStore();
        mock.setId(0);
        Mockito.when(this.guestRepository.save(mock)).thenReturn(mock);
        // do the work
        GuestStore guest = this.controller.create(mock);
        // validate the work
        Assert.assertEquals(0, guest.getId());
    }

    @GetMapping
    public Iterable<GuestStore> list() {
        return this.guestRepository.findAll();
    }

    @GetMapping("{(id}")
    public GuestStore findByID(@PathVariable int id) {
        GuestStore result = this.guestRepository.findById(id).get();
        return result;
    }







    @Test
    public void updateByIDTest() {
        GuestStore mock = new GuestStore();
        mock.setId(0);
        Mockito.when(this.guestRepository.findById(mock.getId())).thenReturn(Optional.of(mock));
        Mockito.when(this.guestRepository.save(mock)).thenReturn(mock);     //GIVEN

        GuestStore guest = this.controller.updateByID(0, mock);         //WHEN


        Assert.assertEquals(0, guest.getId());                     //THEN

//        Mockito.verify(this.guestRepository.save(mock));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByID(@PathVariable int id) {

        this.guestRepository.deleteById(id);
    }


}
