package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BondsController {
    BondsService bondsService;

    @Autowired
    public BondsController(BondsService bs) {
        bondsService = bs;
    }

    @GetMapping("/bonds")
    public List<Bond> getAllBonds() {
        return bondsService.allBonds();
    }

    @PostMapping("/within5days")
    public ResponseEntity<List<Bond>> getBondsWithin5Days(String date) {

        String[] data = date.split("/");
        String dayStr = data[0];
        String monthStr = data[1];
        String yearStr = data[2];

        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);

        LocalDate inputDate = LocalDate.of(year, month, day);

        LocalDate dateBefore7Days = inputDate.minusDays(7);

        LocalDate dateAfter7Days = inputDate.plusDays(7);

//        List<Bond> bondsWithin5Days = bondsService.allBondsWithMaturityDateInInterval(dateBefore7Days, dateAfter7Days);
//
//        if(bondsWithin5Days != null && bondsWithin5Days.size() != 0) {
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(bondsWithin5Days);
//        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(null);

    }
}
