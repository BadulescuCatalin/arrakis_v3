package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    AccountService accountService;

    @Autowired
    public AccountController(AccountService as) {
        accountService = as;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<String> logIn(@RequestBody Map<String, String> credentials ) throws Exception {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> user = accountService.userFromEmail(email);

        if (user.isPresent()) {
            String secretKey = accountService.generateValidAESKey(user.get().getUsername());
            String encryptedPassword = accountService.encryptPassword(password, secretKey);
            if (user.get().getPassword().equals(encryptedPassword)) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body("Logged In");
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Unauthorized access");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Unauthorized access");
        }
    }
}
