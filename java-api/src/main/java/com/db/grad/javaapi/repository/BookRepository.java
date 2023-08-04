package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAll();
}
