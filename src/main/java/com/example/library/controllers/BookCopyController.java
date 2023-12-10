package com.example.library.controllers;

import com.example.library.models.BookCopy;
import com.example.library.repository.BookCopyRepository;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookCopyController {
    @Autowired
    private BookCopyRepository bookCopyRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/bookCopy")
    public String bookCopyMain(Model model) {
        Iterable<BookCopy> bookCopies = bookCopyRepository.findAll();
        model.addAttribute("bookCopies", bookCopies);
        return "bookCopy-main";
    }

    @GetMapping("/bookCopy/add")
    public String bookCopyAdd(Model model) {
        return "bookCopy-add";
    }

    @PostMapping("/bookCopy/add")
    public String bookCopyPostAdd(@RequestParam Long bookId, @RequestParam boolean available, Model model) {
        BookCopy bookCopy = new BookCopy();
        bookCopy.setBook(bookRepository.findById(bookId).orElseThrow());  // Предполагается, что у вас есть bookRepository
        bookCopy.setAvailable(available);
        bookCopyRepository.save(bookCopy);
        return "redirect:/bookCopy";
    }

    @GetMapping("/bookCopy/{id}")
    public String bookCopyDetails(@PathVariable(value = "id") long id, Model model) {
        if (!bookCopyRepository.existsById(id)) {
            return "redirect:/bookCopy";
        }
        Optional<BookCopy> bookCopy = bookCopyRepository.findById(id);
        model.addAttribute("bookCopy", bookCopy.orElse(null));
        return "bookCopy-details";
    }

    @GetMapping("/bookCopy/{id}/edit")
    public String bookCopyEdit(@PathVariable(value = "id") long id, Model model) {
        if (!bookCopyRepository.existsById(id)) {
            return "redirect:/bookCopy";
        }
        Optional<BookCopy> bookCopy = bookCopyRepository.findById(id);
        model.addAttribute("bookCopy", bookCopy.orElse(null));
        return "bookCopy-edit";
    }

    @PostMapping("/bookCopy/{id}/edit")
    public String bookCopyPostUpdate(@PathVariable(value = "id") long id, @RequestParam Long bookId, @RequestParam boolean available, Model model) {
        BookCopy bookCopy = bookCopyRepository.findById(id).orElseThrow();
        bookCopy.setBook(bookRepository.findById(bookId).orElseThrow());
        bookCopy.setAvailable(available);
        bookCopyRepository.save(bookCopy);
        return "redirect:/bookCopy";
    }

    @PostMapping("/bookCopy/{id}/remove")
    public String bookCopyPostDelete(@PathVariable(value = "id") long id, Model model) {
        BookCopy bookCopy = bookCopyRepository.findById(id).orElseThrow();
        bookCopyRepository.delete(bookCopy);
        return "redirect:/bookCopy";
    }
}
