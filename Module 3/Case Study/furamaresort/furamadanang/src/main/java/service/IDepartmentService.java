package service;

import model.Department;

import java.util.List;

public interface IDepartmentService {

    List<Department> findAll();

    Department findById(Long id);
}
