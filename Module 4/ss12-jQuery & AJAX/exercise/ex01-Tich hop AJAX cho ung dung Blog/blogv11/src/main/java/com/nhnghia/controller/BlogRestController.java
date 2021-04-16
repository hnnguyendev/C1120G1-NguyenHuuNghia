package com.nhnghia.controller;

import com.nhnghia.entity.Blog;
import com.nhnghia.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/blog")
public class BlogRestController {

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> index(@PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(blogList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> search(@PageableDefault(size = 2) Pageable pageable, @RequestParam String txtSearch) {
        Page<Blog> blogs = blogService.findByTitleContaining(txtSearch, pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
