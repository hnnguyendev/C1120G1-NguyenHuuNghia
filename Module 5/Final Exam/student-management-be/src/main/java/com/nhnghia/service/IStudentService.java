package com.nhnghia.service;

import com.nhnghia.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Page<Student> findAll(Pageable pageable);

    List<Student> findByContaining(String txtSearch);

    Student findById(Long id);

    Student save(Student student);

    Student deleteById(Long id);
}
