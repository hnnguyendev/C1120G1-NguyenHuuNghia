package mapper;

import model.Employee;
import repository.IDepartmentRepository;
import repository.IEducationRepository;
import repository.IPositionRepository;
import repository.IUserRepository;
import repository.impl.DepartmentRepositoryImpl;
import repository.impl.EducationRepositoryImpl;
import repository.impl.PositionRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements IRowMapper<Employee> {

    IPositionRepository positionRepository = new PositionRepositoryImpl();
    IEducationRepository educationRepository = new EducationRepositoryImpl();
    IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    IUserRepository userRepository = new UserRepositoryImpl();

    @Override
    public Employee mapRow(ResultSet resultSet) {
        Employee employee = new Employee();
        try {
            employee.setId(resultSet.getLong("id"));
            employee.setFullName(resultSet.getString("fullname"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setIdNumber(resultSet.getString("idnumber"));
            employee.setSalary(resultSet.getDouble("salary"));
            employee.setPhoneNumber(resultSet.getString("phonenumber"));
            employee.setEmail(resultSet.getString("email"));
            employee.setAddress(resultSet.getString("address"));
            employee.setFlag(resultSet.getInt("flag"));
            employee.setPosition(positionRepository.findById(resultSet.getLong("positionid")));
            employee.setEducation(educationRepository.findById(resultSet.getLong("educationid")));
            employee.setDepartment(departmentRepository.findById(resultSet.getLong("departmentid")));
            employee.setUser(userRepository.findByUsername(resultSet.getString("username")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }
}
