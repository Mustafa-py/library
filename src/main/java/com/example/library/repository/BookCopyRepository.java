package com.example.library.repository;

import com.example.library.models.BookCopy;
import org.springframework.data.repository.CrudRepository;

public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {
}
