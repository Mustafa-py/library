package com.example.library.controllers;

import com.example.library.models.BookCopy;
import com.example.library.models.BookLoan;
import com.example.library.models.User;
import com.example.library.repository.BookCopyRepository;
import com.example.library.repository.BookLoanRepository;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
public class BookLoanController {

    @Autowired
    private BookLoanRepository bookLoanRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/bookLoan")
    public String bookLoanMain(Model model) {
        Iterable<BookLoan> bookLoans = bookLoanRepository.findAll();
        model.addAttribute("bookLoans", bookLoans);
        return "bookLoan-main";
    }

    @GetMapping("/bookLoan/add")
    public String bookLoanAdd(Model model) {
        Iterable<User> users = userRepository.findAll();
        Iterable<BookCopy> copies = bookCopyRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("copies", copies);

        return "bookLoan-add";
    }

    @PostMapping("/bookLoan/add")
    public String bookLoanPostAdd(
            @RequestParam Long userId,
            @RequestParam Long copyId,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Date startDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Date endDate
    ) {
        BookLoan bookLoan = new BookLoan();
        bookLoan.setUser(userRepository.findById(userId).orElseThrow());
        bookLoan.setBookCopy(bookCopyRepository.findById(copyId).orElseThrow());
        bookLoan.setStartDate(startDate);
        bookLoan.setEndDate(endDate);
        bookLoanRepository.save(bookLoan);
        return "redirect:/bookLoan";
    }


    @GetMapping("/bookLoan/{id}")
    public String bookLoanDetails(@PathVariable(value = "id") long id, Model model) {
        if (!bookLoanRepository.existsById(id)) {
            return "redirect:/bookLoan";
        }
        Optional<BookLoan> bookLoan = bookLoanRepository.findById(id);
        model.addAttribute("bookLoan", bookLoan.orElse(null));
        return "bookLoan-details";
    }

    @PostMapping("/bookLoan/{id}/return")
    public String bookLoanPostReturn(@PathVariable(value = "id") long id, Model model) {
        BookLoan bookLoan = bookLoanRepository.findById(id).orElseThrow();
        bookLoan.getBookCopy().setAvailable(true);
        bookLoanRepository.delete(bookLoan);
        return "redirect:/bookLoan";
    }

    private Date calculateEndDate(Date startDate) {
        // Ваша логика для расчета даты окончания аренды (например, добавление 14 дней)
        return startDate;
    }
}
