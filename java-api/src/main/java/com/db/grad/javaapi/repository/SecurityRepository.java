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
    @Query(nativeQuery = true, value = "SELECT\n" +

            "    c.name AS counter_party_name\n" +
            "FROM\n" +
            "    security s\n" +
            "JOIN\n" +
            "    trades t ON s.id = t.security_id\n" +
            "JOIN\n" +
            "    counter_party c ON t.counter_party_id = c.id\n" +
            "WHERE\n" +
            "    s.isin = :isin")
    String findCounterPartyByIsin(String isin);
    @Query(nativeQuery = true, value =
            "SELECT DISTINCT s.*, b.book_name FROM security s " +
                    "JOIN trades t ON s.id = t.security_id " +
                    "JOIN books b ON t.book_id = b.id " +
                    "JOIN book_user bu ON b.id = bu.book_id " +
                    "JOIN users u ON bu.user_id = u.id " +
                    "WHERE u.email = :email")
    List<String> findBondsInMyBooks(String email);
}
