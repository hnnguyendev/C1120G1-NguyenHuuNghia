package com.nhnghia.controller;

import com.nhnghia.service.impl.CalculateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    CalculateServiceImpl calculateService;

    @GetMapping("/")
    public String getForm() {
        return "index";
    }

    @PostMapping("/calculator")
    public String addition(@RequestParam double firstOperand,
                           @RequestParam double secondOperand,
                           @RequestParam char operator,
                           Model model) {
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        try {
            model.addAttribute("result", calculateService.calculate(firstOperand, secondOperand, operator));
        } catch (Exception e) {
            model.addAttribute("result", e.getMessage());
        }

        return "index";
    }
}
