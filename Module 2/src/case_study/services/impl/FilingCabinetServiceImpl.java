package case_study.services.impl;

import case_study.models.Employee;
import case_study.repositories.IRepository;
import case_study.repositories.impl.RepositoryImpl;
import case_study.services.IFilingCabinetService;

import java.util.List;
import java.util.Stack;

public class FilingCabinetServiceImpl implements IFilingCabinetService {

    private static final String FILE_NAME = "employee.csv";

    IRepository<Employee> repository = new RepositoryImpl<>();

    @Override
    public Employee findEmployeeById(String id) {
        Stack<Employee> employeeStack = findAllEmployee();
        while (true) {
            Employee employee = employeeStack.pop();
            if (employee == null) {
                break;
            }
            if (id.equals(employee.getId())) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Stack<Employee> findAllEmployee() {
        List<String[]> listString = repository.readFile(FILE_NAME);
        Stack<Employee> employeeStack = new Stack<>();
        for (String[] strings : listString) {
            Employee employee = new Employee(strings);
            employeeStack.push(employee);
        }

        return employeeStack;
    }
}
