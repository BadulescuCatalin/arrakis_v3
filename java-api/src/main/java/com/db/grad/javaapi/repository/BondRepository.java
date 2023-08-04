package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BondRepository extends ReadOnlyRepository<Bond, Integer> {
    // Because we've used a view we need to customise the query
    @Query(nativeQuery = true, value = "select * from bond")
    List<Bond> findAll();

    @Query(nativeQuery = true, value ="SELECT b FROM bond b WHERE b.maturityDate BETWEEN :beginDate AND :endDate")
    List<Bond> findBondsByMaturityDateInterval(LocalDate beginDate, LocalDate endDate);

}
