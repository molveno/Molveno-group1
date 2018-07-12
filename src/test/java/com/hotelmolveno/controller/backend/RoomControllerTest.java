package com.hotelmolveno.controller.backend;

import com.hotelmolveno.hotel.Room;
import com.hotelmolveno.hotel.TypeOfBeds;
import com.hotelmolveno.repository.RoomRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class RoomControllerTest {

    @InjectMocks
    private RoomController controller;

    @Mock
    private RoomRepository repo;

    private Room room;


    @Test
    public void testCreate() {

        //Given
        Room room = new Room();
        room.setBedType(TypeOfBeds.TWIN);
        room.setCapacity(3);

        Mockito.when(this.repo.save(room)).thenReturn(room);


        //When
        ResponseEntity<Room> resultFromController = this.controller.create(room);

        // Then
        Assert.assertNotNull(resultFromController.getBody());
        Assert.assertEquals(HttpStatus.CREATED, resultFromController.getStatusCode());

        Assert.assertEquals(3, resultFromController.getBody().getCapacity());
    }

    @Test
    public void testFindByIdExisting() {

        //Given
        Room room = new Room();
        room.setBedType(TypeOfBeds.TWIN);
        room.setCapacity(3);

        Mockito.when(this.repo.findById(3)).thenReturn(Optional.of(room));

        //When
        ResponseEntity<Room> resultFromController = this.controller.findById(3);

        //Then
        Assert.assertEquals(HttpStatus.OK, resultFromController.getStatusCode());

        Assert.assertEquals(TypeOfBeds.TWIN, resultFromController.getBody().getBedType());
    }

    @Test
    public void testFindByIdNonExisting() {

        //Given
        Room room = new Room();
        room.setBedType(TypeOfBeds.TWIN);
        room.setCapacity(3);

        Mockito.when(this.repo.findById(3)).thenReturn(Optional.ofNullable(null));

        //When
        ResponseEntity<Room> resultFromController = this.controller.findById(3);

        //Then
        Assert.assertEquals(HttpStatus.NOT_FOUND, resultFromController.getStatusCode());

        Assert.assertNull(resultFromController.getBody());
    }
}
