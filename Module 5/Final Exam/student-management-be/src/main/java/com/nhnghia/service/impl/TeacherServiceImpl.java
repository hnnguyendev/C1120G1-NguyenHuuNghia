package com.nhnghia.service.impl;

import com.nhnghia.entity.Teacher;
import com.nhnghia.repository.ITeacherRepository;
import com.nhnghia.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    ITeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
