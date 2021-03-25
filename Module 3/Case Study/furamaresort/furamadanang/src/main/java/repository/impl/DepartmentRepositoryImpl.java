package repository.impl;

import mapper.DepartmentMapper;
import model.Department;
import repository.IDepartmentRepository;

import java.util.List;

public class DepartmentRepositoryImpl extends BaseRepositoryImpl<Department> implements IDepartmentRepository {

    public static final String SELECT_ALL_DEPARTMENTS = "select * from departments;";
    public static final String SELECT_DEPARTMENT_BY_ID = "select * from departments where id = ?;";

    @Override
    public List<Department> findAll() {
        return select(SELECT_ALL_DEPARTMENTS, new DepartmentMapper());
    }

    @Override
    public Department findById(Long id) {
        List<Department> departmentList = select(SELECT_DEPARTMENT_BY_ID, new DepartmentMapper(), id);

        return departmentList.isEmpty() ? null : departmentList.get(0);
    }
}
