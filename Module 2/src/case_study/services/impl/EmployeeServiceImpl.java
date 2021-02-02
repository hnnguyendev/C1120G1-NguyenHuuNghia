package case_study.services.impl;

import case_study.models.Employee;
import case_study.repositories.IRepository;
import case_study.repositories.impl.RepositoryImpl;
import case_study.services.IEmployeeService;

import java.util.*;

public class EmployeeServiceImpl implements IEmployeeService {

    private static final String FILE_NAME = "employee.csv";

    IRepository<Employee> repository = new RepositoryImpl<>();

    @Override
    public Map<String, Employee> findAll() {
        List<String[]> listString = repository.readFile(FILE_NAME);
        Map<String, Employee> employeeMap = new HashMap<>();
        for (String[] strings : listString) {
            Employee employee = new Employee(strings);
            employeeMap.put(strings[0], employee);
        }

        return employeeMap;
    }

}
