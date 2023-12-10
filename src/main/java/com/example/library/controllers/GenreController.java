package com.example.library.controllers;

import com.example.library.models.Genre;
import com.example.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/genre")
    public String genreMain(Model model) {
        Iterable<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "genre-main";
    }

    @GetMapping("/genre/add")
    public String genreAdd(Model model) {
        return "genre-add";
    }

    @PostMapping("/genre/add")
    public String genrePostAdd(@RequestParam String genreName, Model model) {
        Genre genre = new Genre();
        genre.setGenreName(genreName);
        genreRepository.save(genre);
        return "redirect:/genre";
    }

    @GetMapping("/genre/{id}")
    public String genreDetails(@PathVariable(value = "id") long id, Model model) {
        if (!genreRepository.existsById(id)) {
            return "redirect:/genre";
        }
        Optional<Genre> genre = genreRepository.findById(id);
        model.addAttribute("genre", genre.orElse(null));
        return "genre-details";
    }

    @GetMapping("/genre/{id}/edit")
    public String genreEdit(@PathVariable(value = "id") long id, Model model) {
        if (!genreRepository.existsById(id)) {
            return "redirect:/genre";
        }
        Optional<Genre> genre = genreRepository.findById(id);
        model.addAttribute("genre", genre.orElse(null));
        return "genre-edit";
    }

    @PostMapping("/genre/{id}/edit")
    public String genrePostUpdate(@PathVariable(value = "id") long id, @RequestParam String genreName, Model model) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genre.setGenreName(genreName);
        genreRepository.save(genre);
        return "redirect:/genre";
    }

    @PostMapping("/genre/{id}/remove")
    public String genrePostDelete(@PathVariable(value = "id") long id, Model model) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genreRepository.delete(genre);
        return "redirect:/genre";
    }
}
