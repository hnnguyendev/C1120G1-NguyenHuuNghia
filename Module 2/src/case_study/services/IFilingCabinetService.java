package case_study.services;

import case_study.models.Employee;

import java.util.Stack;

public interface IFilingCabinetService {

    Employee findEmployeeById(String id);

    Stack<Employee> findAllEmployee();

}
