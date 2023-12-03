package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public String bookMain(Model model){
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-main";
    }
    @GetMapping("/book/add")
    public String bookAdd(Model model){
        return "book-add";
    }
    @PostMapping("/book/add")
    public String bookPostAdd(@RequestParam String title,@RequestParam  String author, @RequestParam int publication_year,@RequestParam  String isbn ,Model model){
        Book book = new Book(title,author,publication_year,isbn);
        bookRepository.save(book);
        return "redirect:/book";
    }

}
