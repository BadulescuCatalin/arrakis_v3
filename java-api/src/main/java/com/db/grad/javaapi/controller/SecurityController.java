package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.BondDetailed;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.BondsService;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class SecurityController {

    @Autowired
    SecurityService securityService;

    @GetMapping("/securities")
    public List<BondDetailed> getAllSecurities() {
        return securityService.getAllBondsDetailed();
    }

    @PostMapping("/securities/within5days")
    public ResponseEntity<List<Security>> getBondsWithin5Days(@RequestBody Map<String, String> dateMap) {

        String date = dateMap.get("date");
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

        Date date1 = Date.from(dateBefore7Days.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date date2 = Date.from(dateAfter7Days.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Security> bondsWithin5Days = securityService.allSecuritiesWithMaturityDateInInterval(date1, date2);

        if(bondsWithin5Days != null && bondsWithin5Days.size() != 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(bondsWithin5Days);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(null);
    }

    @PostMapping("/securities/issinAndOrCusip")
    public ResponseEntity<List<Security>> getSecuritiesByIsinAndOrCusip(@RequestBody Map<String, String> map) {
        String cusip = "";
        String isin = "";
        if(map.containsKey("isin")) {
            isin = map.get("isin");
        }
        if(map.containsKey("cusip")) {
            cusip = map.get("cusip");
        }
        List<Security> securities = securityService.getByIsinAndOrCusip(isin, cusip);
        if(securities != null && securities.size() != 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(securities);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(null);
    }

    @PostMapping("/securities/issinOrCusip")
    public ResponseEntity<List<Security>> getSecuritiesByIsinOrCusip(@RequestBody Map<String, String> map) {
        String data = "";
        data = map.get("data");
        List<Security> securities = securityService.getSecuritiesByIsinOrCusip(data);
        if(securities != null && securities.size() != 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(securities);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(null);
    }

    @PostMapping("security/counter_party_name")
    public ResponseEntity<List<String>> getCounterPartyByIsin(@RequestBody Map<String, String> map) {
        String isin = map.get("isin");
        List<String> res =  securityService.getCounterPartyByIsin(isin);
        return ResponseEntity.status(HttpStatus.OK)
                .body(res);
    }

    @PostMapping("security/myBooks")
    public ResponseEntity<List<String>> findBondsInMyBooks(@RequestBody Map<String, String> map) {
        String email = map.get("email");
        List<String> list = new ArrayList<>();
        list =  securityService.getBondsInMyBooks(email);
        if(list != null && list.size() != 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(list);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(null);
    }
}
