package com.hotelmolveno.repository;

import com.hotelmolveno.hotel.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> { // temporarily int, refactor later to Long

    // in real live we would have a real DB here .... like Oracle, MySQL or Postgres

}