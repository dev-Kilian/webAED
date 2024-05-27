package com.KilianElRincon.webAED.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
