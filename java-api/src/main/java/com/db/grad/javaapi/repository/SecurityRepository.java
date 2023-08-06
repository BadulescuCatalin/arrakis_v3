package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer> {
    List<Security> findAll();
    @Query(nativeQuery = true, value ="SELECT * FROM security s WHERE s.maturity_date BETWEEN :beginDate AND :endDate")
    List<Security> findSecurityByMaturityDateInterval(Date beginDate, Date endDate);
    List<Security> findByIsinOrCusip(String isin, String cusip);
    List<Security> findByIsinAndCusip(String isin, String cusip);
}
