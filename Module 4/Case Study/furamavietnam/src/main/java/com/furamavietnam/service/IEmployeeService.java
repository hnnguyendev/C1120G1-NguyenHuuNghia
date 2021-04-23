package com.furamavietnam.service;

import com.furamavietnam.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByContaining(String txtSearch, Pageable pageable);

    Employee findById(Long id);

    Employee save(Employee employee);
    
    Employee deleteById(Long id);
}
