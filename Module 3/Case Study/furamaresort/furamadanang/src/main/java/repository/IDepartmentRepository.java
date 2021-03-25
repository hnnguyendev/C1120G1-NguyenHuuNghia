package repository;

import model.Department;

import java.util.List;

public interface IDepartmentRepository {

    List<Department> findAll();

    Department findById(Long id);

}
