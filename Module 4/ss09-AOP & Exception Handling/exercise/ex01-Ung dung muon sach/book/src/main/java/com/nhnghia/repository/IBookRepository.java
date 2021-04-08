package com.nhnghia.repository;

import com.nhnghia.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {

    Book findByCode(String code);
}
