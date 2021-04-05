package com.nhnghia.service;

import com.nhnghia.entity.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void delete(Long id);

}
