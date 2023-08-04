package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BondRepository extends ReadOnlyRepository<Bond, Integer> {
    // Because we've used a view we need to customise the query
        @Query(nativeQuery = true, value = "select " +
                "id, isin, cusip, issuer_name, bond_maturity_date, coupon, type, face_value," +
                "bond_currency, bond_status, trade_currency, trade_status, quantity, " +
                "unit_price, buy_sell, trade_date, settlement_date, book_name, bond_holder" +
                " from all_bonds")
        List<Bond> findAll();
}
