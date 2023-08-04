package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
public interface BondRepository extends ReadOnlyRepository<Bond, Integer> {
    // Because we've used a view we need to customise the query
        @Query(nativeQuery = true, value = "select * from all_bonds")
        List<Bond> findAll();
}
