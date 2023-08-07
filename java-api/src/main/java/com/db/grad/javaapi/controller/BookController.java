package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeService;
import com.db.grad.javaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    TradeService tradeService;

    @GetMapping("/books")
    public List<Book> getAllBonds() {
        return bookService.allBooks();
    }

    @PostMapping("/myBooks")
    public List<String> getMyBooks(@RequestBody Map<String, String> map){
        String email = map.get("email");
        return bookService.getUserBooks(email);
    }

    @PostMapping("/myBooks/trades")
    public List<Trade> getTradesFromBooks(@RequestBody Map<String, String> map){
        String email = map.get("email");
        List<String> idsString = bookService.getUserBooks(email);
        List<Integer> ids = new ArrayList<>();
        for(String s : idsString) {
            String idStr = s.split(",")[0];
            int id = Integer.parseInt(idStr);
            ids.add(id);
        }
        return tradeService.getTradeByBookId(ids);
    }

}
