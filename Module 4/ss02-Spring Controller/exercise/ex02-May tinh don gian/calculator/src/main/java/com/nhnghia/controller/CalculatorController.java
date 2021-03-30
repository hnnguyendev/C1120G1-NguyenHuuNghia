package com.nhnghia.controller;

import com.nhnghia.service.impl.CalculateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    CalculateImpl calculate;

    @GetMapping("/")
    public String getForm() {
        return "index";
    }

    @PostMapping("/calculator")
    public String addition(@RequestParam double firstOperand,
                           @RequestParam double secondOperand,
                           @RequestParam char operator,
                           Model model) {
        double result = 0;
        switch (operator) {
            case '+':
                result = calculate.addition(firstOperand, secondOperand);
                model.addAttribute("txtOperator", "Addition");
                break;
            case '-':
                result = calculate.subtraction(firstOperand, secondOperand);
                model.addAttribute("txtOperator", "Subtraction");
                break;
            case '*':
                result = calculate.multiplication(firstOperand, secondOperand);
                model.addAttribute("txtOperator", "Multiplication");
                break;
            case '/':
                if (secondOperand == 0) {
                    model.addAttribute("message", "Can not divide Zero!");
                } else {
                    result = calculate.division(firstOperand, secondOperand);
                    model.addAttribute("txtOperator", "Division");
                }
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
