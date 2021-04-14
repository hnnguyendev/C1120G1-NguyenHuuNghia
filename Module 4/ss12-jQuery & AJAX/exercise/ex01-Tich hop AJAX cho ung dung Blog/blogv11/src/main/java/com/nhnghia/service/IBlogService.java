package com.nhnghia.service;

import com.nhnghia.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void delete(Long id);

    Page<Blog> findByTitleContaining(String txtSearch, Pageable pageable);

    List<Blog> findByTitleContaining(String txtSearch);

    Page<Blog> findByCategoryId(Long id, Pageable pageable);

//    Page<Blog> findAll(Pageable pageable, Sort sort);

    Page<Blog> findByOrderByCreateDateAsc(Pageable pageable);

    Page<Blog> findByOrderByCreateDateDesc(Pageable pageable);

}
