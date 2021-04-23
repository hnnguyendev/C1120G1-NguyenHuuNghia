package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void update(Long id, Employee employee) {
        employeeRepository.update(id, employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.remove(id);
    }

    @Override
    public List<Employee> search(String txtSearch) {
        return employeeRepository.search(txtSearch);
    }
}
