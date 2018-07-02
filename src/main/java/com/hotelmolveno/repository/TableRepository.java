package com.hotelmolveno.repository;

import com.hotelmolveno.restaurant.Table;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class TableRepository {

    private static long lastId = 0;

    private Map<Long, Table> tables = new HashMap<>();  // this you might see as a mock db

    @PostConstruct
    public void addSomeTablesToGetStarted() {
        for(int i = 0;i<5;i++) {
            Table table = new Table();
            table.setName("Tafel "+ i);
            this.save(table);
        }
    }

    public void save(Table newTable) {
        newTable.setId(++lastId);
        this.tables.put(newTable.getId(), newTable);

    }

    public Collection<Table> findAll() {
        return this.tables.values();
    }

    public Table findById(long id) {

        Table found = this.tables.get(id);

        return found;
    }

}
