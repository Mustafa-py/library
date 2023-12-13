package com.example.library.repository;

import com.example.library.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b.id FROM Book b WHERE NOT EXISTS (SELECT 1 FROM BookCopy bc WHERE bc.book.id = b.id)")
    List<Long> findAvailableBookIds();

}
