package com.example.library.repository;

import com.example.library.models.BookLoan;
import org.springframework.data.repository.CrudRepository;

public interface BookLoanRepository extends CrudRepository<BookLoan, Long> {
}
