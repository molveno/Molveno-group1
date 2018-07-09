package com.hotelmolveno.repository;

import com.hotelmolveno.finance.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository <Bill, Long>{
}
