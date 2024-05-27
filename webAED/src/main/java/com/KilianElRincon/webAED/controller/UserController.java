package com.KilianElRincon.webAED.controller;

import com.KilianElRincon.webAED.models.User;
import com.KilianElRincon.webAED.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user-list";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "user-detail";
    }

    @GetMapping("/user-create")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "user-list";
    }

    @GetMapping("/users/{id}/edit")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/users/{id}/edit")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute User user) {
        userRepository.save(user);
        return "user-list";
    }

    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
        return "user-list";
    }
}
