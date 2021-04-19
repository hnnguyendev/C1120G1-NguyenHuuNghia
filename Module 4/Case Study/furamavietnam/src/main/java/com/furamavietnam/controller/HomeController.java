package com.furamavietnam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/furamavietnam"})
public class HomeController {

    @GetMapping
    public String getHomePage() {

        return "web/index";
    }

    @GetMapping("/login")
    public String getLoginPage() {

        return "web/login";
    }
}
