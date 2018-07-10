package com.hotelmolveno.controller.backend;

import com.hotelmolveno.finance.Bill;
import com.hotelmolveno.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/bills")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @PostMapping
    public ResponseEntity<Bill> create(@RequestBody Bill newBill) {

        this.billRepository.save(newBill);

        return new ResponseEntity<Bill>(newBill, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Bill>> list() {
        return new ResponseEntity<Iterable<Bill>>(this.billRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Bill> findById(@PathVariable long id) {

        Optional<Bill> possibleResult = this.billRepository.findById(id);

        if (possibleResult.isPresent()) {
            Bill result = possibleResult.get();
            return new ResponseEntity<Bill>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        this.billRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Bill> update(@PathVariable long id, @RequestBody Bill input) {

        Optional<Bill> possibleOutput = this.billRepository.findById(id);

        if (possibleOutput.isPresent()) {
            Bill output = possibleOutput.get();

//            output.setNumberOfGuests(input.getNumberOfGuests());
//            output.setPrice(input.getPrice());
//            output.setReserved(input.getReserved());

            output = this.billRepository.save(output);

            return new ResponseEntity<Bill>(this.billRepository.save(output), HttpStatus.OK);

        } else {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }


    }


}
