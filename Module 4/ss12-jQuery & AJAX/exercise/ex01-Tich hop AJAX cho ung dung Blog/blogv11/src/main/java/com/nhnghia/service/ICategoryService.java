package com.nhnghia.service;

import com.nhnghia.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void delete(Long id);

}
