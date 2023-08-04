package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SecurityService {

    @Autowired
    SecurityRepository securityRepository;

    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }
}
