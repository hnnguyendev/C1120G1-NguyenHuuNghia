package com.nhnghia.controller;

import com.nhnghia.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mycounter")
public class MyContactController {

    @ModelAttribute("mycounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String getCounter(@ModelAttribute("mycounter") MyCounter myCounter) {
        myCounter.increment();

        return "index";
    }

}
