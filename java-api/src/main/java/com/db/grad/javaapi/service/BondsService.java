package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BondsService {

    @Autowired
    private BondRepository bondRepository;

    public List<Bond> allBonds() {
        return bondRepository.findAll();
    }
    public List<Bond> allBondsWithMaturityDateInInterval(Date begin, Date end) {
        return bondRepository.findBondsByMaturityDateInterval(begin, end);
    }
}
