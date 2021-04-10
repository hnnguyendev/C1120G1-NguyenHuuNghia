package com.nhnghia.service;

import com.nhnghia.entity.Book;
import com.nhnghia.exception.IncorrectCodeException;
import com.nhnghia.exception.OutOfStockException;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    Book findById(Long id);

    void rent(Book book) throws OutOfStockException;

    void returnBack(String code) throws IncorrectCodeException;

}
