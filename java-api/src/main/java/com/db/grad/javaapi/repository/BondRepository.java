package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BondRepository extends ReadOnlyRepository<Bond, Integer> {
    List<Bond> findAll();
    @Query(nativeQuery = true, value ="SELECT b FROM bond b WHERE b.bond_maturity_date BETWEEN :beginDate AND :endDate")
    List<Bond> findBondsByMaturityDateInterval(Date beginDate, Date endDate);
}
