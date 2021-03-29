package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {

    @GetMapping("/")
    public String convert() {
        return "index";
    }

    @PostMapping("/convert")
    public String convertToVnd(@RequestParam Integer usd, Model model) {
        int vnd = usd * 23000;
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
