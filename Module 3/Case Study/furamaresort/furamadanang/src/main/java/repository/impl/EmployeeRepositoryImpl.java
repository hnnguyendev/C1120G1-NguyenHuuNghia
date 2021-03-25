package repository.impl;

import mapper.EmployeeMapper;
import model.Employee;
import repository.IEmployeeRepository;

import java.util.List;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements IEmployeeRepository {

    public static final String INSERT_EMPLOYEE = "insert into employees (fullname, birthday, idnumber, salary, phonenumber, " +
            "email, address, flag, positionid, educationid, departmentid, username) values (?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String SELECT_ALL_EMPLOYEES = "select * from employees where flag = ?;";
    public static final String SELECT_EMPLOYEE_BY_ID = "select * from employees where id = ?;";
    public static final String UPDATE_EMPLOYEE = "update employees set fullname = ?, birthday = ?, idnumber = ?, salary = ?, " +
            "phonenumber = ?, email = ?, address = ?, positionid = ?, educationid = ?, departmentid = ? where id = ?;";
    public static final String DELETE_EMPLOYEE = "update employees set flag = ? where id = ?;";
    public static final String SEARCH_EMPLOYEE = "call searchEmployee(?);";

    @Override
    public void save(Employee employee) {
        update(INSERT_EMPLOYEE,
                employee.getFullName(),
                employee.getBirthday(),
                employee.getIdNumber(),
                employee.getSalary(),
                employee.getPhoneNumber(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getFlag(),
                employee.getPosition().getId(),
                employee.getEducation().getId(),
                employee.getDepartment().getId(),
                employee.getUser().getUsername()
        );
    }

    @Override
    public List<Employee> findAll() {
        return select(SELECT_ALL_EMPLOYEES, new EmployeeMapper(), 1);
    }

    @Override
    public Employee findById(Long id) {
        List<Employee> employeeList = select(SELECT_EMPLOYEE_BY_ID, new EmployeeMapper(), id);

        return employeeList.isEmpty() ? null : employeeList.get(0);
    }

    @Override
    public void update(Long id, Employee employee) {
        update(UPDATE_EMPLOYEE,
                employee.getFullName(),
                employee.getBirthday(),
                employee.getIdNumber(),
                employee.getSalary(),
                employee.getPhoneNumber(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getPosition().getId(),
                employee.getEducation().getId(),
                employee.getDepartment().getId(),
                id
        );
    }

    @Override
    public void remove(Long id) {
        update(DELETE_EMPLOYEE, 0, id);
    }

    @Override
    public List<Employee> search(String txtSearch) {
        return select(SEARCH_EMPLOYEE, new EmployeeMapper(), txtSearch);
    }
}
