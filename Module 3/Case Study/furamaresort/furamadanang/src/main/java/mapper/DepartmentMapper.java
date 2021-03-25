package mapper;

import model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements IRowMapper<Department> {

    @Override
    public Department mapRow(ResultSet resultSet) {
        Department department = new Department();
        try {
            department.setId(resultSet.getLong("id"));
            department.setDepartment(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return department;
    }
}
