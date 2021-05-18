package com.nhnghia.service.impl;

import com.nhnghia.entity.Student;
import com.nhnghia.repository.IStudentRepository;
import com.nhnghia.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> findByContaining(String txtSearch) {
        return studentRepository.findByContaining(txtSearch);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student deleteById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        studentRepository.deleteById(id);

        return student;
    }
}
