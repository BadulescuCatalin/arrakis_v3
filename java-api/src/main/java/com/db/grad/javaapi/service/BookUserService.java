package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.repository.BookUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookUserService {

    @Autowired
    BookUserRepository bookUserRepository;

    public List<BookUser> getAllBookUsers() {
        return bookUserRepository.findAll();
    }
}
