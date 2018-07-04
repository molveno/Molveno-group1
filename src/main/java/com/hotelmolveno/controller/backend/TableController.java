package com.hotelmolveno.controller.backend;

import com.hotelmolveno.repository.TableRepository;
import com.hotelmolveno.restaurant.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableRepository tableRepository;


    @PostMapping
    public Table create(@RequestBody Table newTable) {

        this.tableRepository.save(newTable);

        return newTable;
    }

    @GetMapping
    public Collection<Table> list() {
        return this.tableRepository.findAll();
    }

    @GetMapping("{id}")
    public Table findById(@PathVariable long id) {

        Table result = this.tableRepository.findById(id);

        return result;
    }

}
