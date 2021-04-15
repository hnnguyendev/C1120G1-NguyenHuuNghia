package com.nhnghia.service.impl;

import com.nhnghia.entity.Blog;
import com.nhnghia.repository.IBlogRepository;
import com.nhnghia.service.IBlogService;
import com.nhnghia.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            blog.setCreateDate(DateUtil.getCurrentDate());
        }
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByTitleContaining(String txtSearch, Pageable pageable) {
        return blogRepository.findByTitleContaining(txtSearch, pageable);
    }

    @Override
    public Page<Blog> findByCategoryId(Long id, Pageable pageable) {
        return blogRepository.findByCategoryId(id, pageable);
    }

//    @Override
//    public Page<Blog> findAll(Pageable pageable, Sort sort) {
//        return blogRepository.findAll(pageable, sort);
//    }

    @Override
    public Page<Blog> findByOrderByCreateDateAsc(Pageable pageable) {
        return blogRepository.findByOrderByCreateDateAsc(pageable);
    }

    @Override
    public Page<Blog> findByOrderByCreateDateDesc(Pageable pageable) {
        return blogRepository.findByOrderByCreateDateDesc(pageable);
    }

}
