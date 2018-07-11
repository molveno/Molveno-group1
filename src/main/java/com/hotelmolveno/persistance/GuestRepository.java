package com.hotelmolveno.persistance;

import com.hotelmolveno.user.GuestStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<GuestStore, Integer> {
}
