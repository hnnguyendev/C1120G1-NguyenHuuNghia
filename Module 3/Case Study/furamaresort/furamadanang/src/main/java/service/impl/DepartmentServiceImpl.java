package service.impl;

import model.Department;
import repository.IDepartmentRepository;
import repository.impl.DepartmentRepositoryImpl;
import service.IDepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {

    IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id);
    }
}
