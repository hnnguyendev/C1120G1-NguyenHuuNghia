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
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/blog")
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

    @GetMapping("")
    public ResponseEntity<Page<Blog>> index(@PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(blogList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> search(@PageableDefault(size = 5) Pageable pageable, @RequestParam String txtSearch) {
        Page<Blog> blogs = blogService.findByTitleContaining(txtSearch, pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
