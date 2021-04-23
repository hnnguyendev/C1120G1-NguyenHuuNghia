package com.furamavietnam.service.impl;

import com.furamavietnam.entity.Department;
import com.furamavietnam.repository.IDepartmentRepository;
import com.furamavietnam.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    IDepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
