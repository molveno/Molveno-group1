package com.hotelmolveno.repository;

import com.hotelmolveno.user.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {


}
