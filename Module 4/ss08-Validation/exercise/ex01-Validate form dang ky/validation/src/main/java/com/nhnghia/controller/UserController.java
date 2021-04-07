package com.nhnghia.controller;

import com.nhnghia.entity.User;
import com.nhnghia.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("")
    public String getCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());

        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid User user, ModelMap modelMap, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("user", user);
            return "index";
        } else {
            modelMap.addAttribute("user", user);
            userService.save(user);
            return "result";
        }
    }
}
