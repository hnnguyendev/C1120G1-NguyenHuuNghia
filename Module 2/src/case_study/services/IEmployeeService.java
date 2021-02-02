package case_study.services;

import case_study.models.Employee;

import java.util.Map;

public interface IEmployeeService {

    Map<String, Employee> findAll();

}
