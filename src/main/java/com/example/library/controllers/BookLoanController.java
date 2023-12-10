package com.example.library.controllers;

import com.example.library.models.BookLoan;
import com.example.library.repository.BookCopyRepository;
import com.example.library.repository.BookLoanRepository;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        // Здесь вы можете добавить логику для получения списка доступных книг и копий для аренды
        // и передать их в модель для отображения на странице добавления аренды.
        return "bookLoan-add";
    }

    @PostMapping("/bookLoan/add")
    public String bookLoanPostAdd(@RequestParam Long userId, @RequestParam Long copyId, Model model) {
        BookLoan bookLoan = new BookLoan();
        bookLoan.setUser(userRepository.findById(userId).orElseThrow()); // Предполагается, что у вас есть userRepository
        bookLoan.setBookCopy(bookCopyRepository.findById(copyId).orElseThrow()); // Предполагается, что у вас есть bookCopyRepository
        bookLoan.setStartDate(new Date()); // Установите начальную дату аренды
        // Установите дату окончания аренды в соответствии с вашей логикой
        bookLoan.setEndDate(calculateEndDate(bookLoan.getStartDate()));
        bookLoanRepository.save(bookLoan);
        return "redirect:/bookLoan";
    }

    // Дополнительные методы для работы с арендой

    private Date calculateEndDate(Date startDate) {
        // Ваша логика для расчета даты окончания аренды (например, добавление 14 дней)
        return startDate;
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
        // Добавьте логику для возврата книги, установки даты возврата, и т.д.
        // Обновите статус копии книги
        bookLoan.getBookCopy().setAvailable(true);
        bookLoanRepository.delete(bookLoan);
        return "redirect:/bookLoan";
    }
}
