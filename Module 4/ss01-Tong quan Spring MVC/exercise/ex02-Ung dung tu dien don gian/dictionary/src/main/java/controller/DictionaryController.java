package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    @GetMapping("/search")
    public String showSearchForm() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String txtSearch, Model model) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("book", "sach");
        stringMap.put("car", "xe");
        stringMap.put("pen", "but bi");
        stringMap.put("apple", "tao");
        stringMap.put("candy", "keo");

        String result = stringMap.get(txtSearch);

        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Not Found");
        }

        return "result";
    }
}
