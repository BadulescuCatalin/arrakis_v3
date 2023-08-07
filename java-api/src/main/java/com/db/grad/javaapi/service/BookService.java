package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public List<String> getUserBooks(String email) {
        return bookRepository.findByEmail(email);
    }

//    public List<Trade> getAllTradesFromListOfBookIds(List<Integer> ids) {
//        List<Trade> trades = new ArrayList<>();
//        for(int id : ids) {
//            List<Trade> t = bookRepository.findTradeByBookId(id);
//            trades.addAll(bookRepository.findTradeByBookId(id));
//        }
//        return trades;
//    }
}
