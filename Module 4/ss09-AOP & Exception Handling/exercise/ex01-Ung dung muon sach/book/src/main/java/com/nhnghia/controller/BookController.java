package com.nhnghia.controller;

import com.nhnghia.entity.Book;
import com.nhnghia.entity.Counter;
import com.nhnghia.exception.IncorrectCodeException;
import com.nhnghia.exception.OutOfStockException;
import com.nhnghia.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    Counter counter;

    @GetMapping("")
    public String getBookList(ModelMap modelMap) {
        modelMap.addAttribute("bookList", bookService.findAll());
        counter.increment();

        return "index";
    }

    @GetMapping("/rent/{id}")
    public String showRentForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("book", bookService.findById(id));

        return "detail";
    }

    @PostMapping("/rent")
    public String rentBook(@ModelAttribute Book book, ModelMap modelMap) throws OutOfStockException {
        modelMap.addAttribute("bookList", bookService.findAll());
        bookService.rent(book);
        return "index";
    }

    @PostMapping("/back")
    public String returnBackBook(@RequestParam String code, ModelMap modelMap) throws IncorrectCodeException {

        modelMap.addAttribute("bookList", bookService.findAll());
        bookService.returnBack(code);
        return "index";
    }

    @ExceptionHandler({OutOfStockException.class, IncorrectCodeException.class})
    public String showErrorPage(){
        return "error";
    }
}
