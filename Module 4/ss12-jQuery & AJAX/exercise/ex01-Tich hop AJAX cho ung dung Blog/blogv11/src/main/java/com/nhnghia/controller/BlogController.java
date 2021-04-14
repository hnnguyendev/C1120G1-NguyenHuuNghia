package com.nhnghia.controller;

import com.nhnghia.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String listAll(@RequestParam Optional<String> txtSearch, ModelMap modelMap) {
        if (txtSearch.isPresent()) {
            modelMap.addAttribute("blogList", blogService.findByTitleContaining(txtSearch.get()));
        } else {
            modelMap.addAttribute("blogList", blogService.findAll());
        }
        return "blog/list";
    }

}
