package com.nhnghia.controller;

import com.nhnghia.entity.Book;
import com.nhnghia.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("")
    public String getBookList(ModelMap modelMap) {
        modelMap.addAttribute("bookList", bookService.findAll());

        return "index";
    }

    @GetMapping("/rent/{id}")
    public String showRentForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("book", bookService.findById(id));

        return "detail";
    }

    @PostMapping("/rent")
    public String rentBook(@ModelAttribute Book book, ModelMap modelMap) {
        if (bookService.isRent(book)) {
            modelMap.addAttribute("bookList", bookService.findAll());
            return "index";
        } else {
            return "error";
        }
    }

    @PostMapping("/back")
    public String returnBackBook(@RequestParam String code, ModelMap modelMap) {
        if (bookService.isReturnBack(code)) {
            modelMap.addAttribute("bookList", bookService.findAll());
            return "index";
        } else {
            return "error";
        }
    }
}
