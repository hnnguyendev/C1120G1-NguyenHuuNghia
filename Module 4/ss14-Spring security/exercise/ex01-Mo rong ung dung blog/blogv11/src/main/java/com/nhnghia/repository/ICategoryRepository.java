package com.nhnghia.repository;

import com.nhnghia.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Page<Category> findAll(Pageable pageable);



}
