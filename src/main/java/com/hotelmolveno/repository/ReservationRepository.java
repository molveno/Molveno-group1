package com.hotelmolveno.repository;

import com.hotelmolveno.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository <Reservation, Long> {



}
