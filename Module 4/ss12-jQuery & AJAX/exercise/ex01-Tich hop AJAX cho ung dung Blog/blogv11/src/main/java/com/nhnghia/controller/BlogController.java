package com.nhnghia.controller;

import com.nhnghia.entity.Blog;
import com.nhnghia.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("/test")
    public String listAll(@RequestParam Optional<String> txtSearch, ModelMap modelMap) {
        if (txtSearch.isPresent()) {
            modelMap.addAttribute("blogList", blogService.findByTitleContaining(txtSearch.get()));
        } else {
            modelMap.addAttribute("blogList", blogService.findAll());
        }
        return "blog/list";
    }

}
