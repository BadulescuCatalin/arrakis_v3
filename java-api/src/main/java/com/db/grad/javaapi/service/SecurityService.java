package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.BondDetailed;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SecurityService {

    @Autowired
    SecurityRepository securityRepository;

    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }
    public List<Security> allSecuritiesWithMaturityDateInInterval(Date begin, Date end) {
        return securityRepository.findSecurityByMaturityDateInterval(begin, end);
    }
    public List<Security> getByIsinAndOrCusip(String isin, String cusip) {
        if(!isin.equals("") && !cusip.equals("")) {
            return securityRepository.findByIsinAndCusip(isin, cusip);
        }
        return securityRepository.findByIsinOrCusip(isin, cusip);
    }

    public List<Security> getSecuritiesByIsinOrCusip(String data) {
        return securityRepository.findSecurityByIsinOrCusip(data);
    }

    public List<String> getCounterPartyByIsin(String isin) {
        return securityRepository.findCounterPartyByIsin(isin);
    }

    public List<Security> getBondsInMyBooks(Integer id, String email) {
        return securityRepository.findBondsInMyBooks(id, email);
    }

    public List<BondDetailed> getAllBondsDetailed() {
        List<Security> securities = getAllSecurities();
        List<BondDetailed> detailed = new ArrayList<>();
        BondDetailed bond = null;
        for (Security s : securities) {
            detailed.add(new BondDetailed(s, securityRepository.findCounterPartyByIsin(s.getIsin())));
        }
        return detailed;
    }
}
