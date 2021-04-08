package com.nhnghia.service;

import com.nhnghia.entity.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    Book findById(Long id);

    boolean isRent(Book book);

    boolean isReturnBack(String code);

}
