package com.nhnghia.service.impl;

import com.nhnghia.entity.Book;
import com.nhnghia.repository.IBookRepository;
import com.nhnghia.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean isRent(Book book) {
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);

            return true;
        }
        return false;
    }

    @Override
    public boolean isReturnBack(String code) {
        Book book;
        for (Book bookItem : bookRepository.findAll()) {
            if (bookItem.getCode().equals(code)) {
                book = bookRepository.findByCode(code);
                book.setQuantity(book.getQuantity() + 1);
                bookRepository.save(book);

                return true;
            }
        }
        return false;
    }
}
