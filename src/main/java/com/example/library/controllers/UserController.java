package com.example.library.controllers;

import com.example.library.models.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String userMain(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user-main";
    }

    @GetMapping("/user/add")
    public String userAdd(Model model) {
        return "user-add";
    }

    @PostMapping("/user/add")
    public String userPostAdd(@RequestParam String name, @RequestParam String email, @RequestParam String address, Model model) {
        User user = new User(name, email, address);
        userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable(value = "id") long id, Model model) {
        if (!userRepository.existsById(id)) {
            return "redirect:/user";
        }
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> result = new ArrayList<>();
        user.ifPresent(result::add);
        model.addAttribute("user", result);
        return "user-details";
    }


    @GetMapping("/user/{id}/edit")
    public String userEdit(@PathVariable(value = "id") long id, Model model) {
        if (!userRepository.existsById(id)) {
            return "redirect:/user";
        }
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> result = new ArrayList<>();
        user.ifPresent(result::add);
        model.addAttribute("user", result);
        return "user-edit";
    }

    @PostMapping("/user/{id}/edit")
    public String userPostUpdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String email, @RequestParam String address, Model model) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        userRepository.save(user);
        return "redirect:/user";
    }


    @PostMapping("/user/{id}/remove")
    public String userPostDelete(@PathVariable(value = "id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return "redirect:/user";
    }
}

