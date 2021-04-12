package com.nhnghia.controller;

import com.nhnghia.entity.Blog;
import com.nhnghia.service.IBlogService;
import com.nhnghia.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {

    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getAll(@RequestParam Optional<Long> categoryIdKey, @PageableDefault(value = 15) Pageable pageable) {
        Page<Blog> blogs;
        if (categoryIdKey.isPresent()) {
            blogs = blogService.findByCategoryId(categoryIdKey.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }

        if (blogs.isEmpty()) {
            return new ResponseEntity<Page<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Blog>>(blogs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Blog blog) {
        blogService.save(blog);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/view/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getOne(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

}
