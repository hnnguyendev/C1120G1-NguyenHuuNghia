package com.nhnghia.controller;

import com.nhnghia.entity.Category;
import com.nhnghia.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Category>> getAll(@PageableDefault(value = 15) Pageable pageable) {
        Page<Category> categories = categoryService.findAll(pageable);
        if (categories.isEmpty()) {
            return new ResponseEntity<Page<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Category>>(categories, HttpStatus.OK);
    }

}
