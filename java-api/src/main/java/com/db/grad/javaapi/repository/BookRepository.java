package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAll();

    @Query(nativeQuery = true, value = "SELECT DISTINCT\n" +
            "    b.* \n" +
            "FROM\n" +
            "    book_user bu\n" +
            "JOIN\n" +
            "    users u ON u.id = bu.user_id\n" +
            "JOIN\n" +
            "    books b ON bu.book_id = b.id\n" +
            "WHERE\n" +
            "    u.email = :email")
    List<String> findByEmail(String email);
//    @Query(nativeQuery = true, value = "select t.* from trades t join books b on t.book_id = b.id where b.id = :id")
//    List<Trade> findTradeByBookId(Integer id);
}
