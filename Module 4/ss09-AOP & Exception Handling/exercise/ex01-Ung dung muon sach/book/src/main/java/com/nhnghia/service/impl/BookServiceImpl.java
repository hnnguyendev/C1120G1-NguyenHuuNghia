package com.nhnghia.service.impl;

import com.nhnghia.entity.Book;
import com.nhnghia.exception.IncorrectCodeException;
import com.nhnghia.exception.OutOfStockException;
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
    public void rent(Book book) throws OutOfStockException {
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
        } else {
            throw new OutOfStockException("Out of stock, please rent other book.");
        }
    }

    @Override
    public void returnBack(String code) throws IncorrectCodeException {
        Book book = bookRepository.findByCode(code);
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
        } else {
            throw new IncorrectCodeException("The code do not exist.");
        }
    }
}
