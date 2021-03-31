package com.nhnghia.controller;

import com.nhnghia.model.Email;
import com.nhnghia.service.impl.SettingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    SettingServiceImpl settingService;

    @GetMapping("/show-form")
    public ModelAndView showForm(Model model) {
        List<String> languageList = settingService.findAllLanguage();
        List<Integer> pageSizeList = settingService.findAllPageSize();
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);

        return new ModelAndView("index", "email", new Email());
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email, Model model) {
        List<String> languageList = settingService.findAllLanguage();
        List<Integer> pageSizeList = settingService.findAllPageSize();
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);

        return "index";
    }
}
