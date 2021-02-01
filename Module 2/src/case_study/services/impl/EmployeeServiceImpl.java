package case_study.services.impl;

import case_study.models.Employee;
import case_study.services.IEmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {

    static Map<String, Employee> employeeMap = new HashMap<>();

    static {
        employeeMap.put("001", new Employee("1", "Ho Ngoc Dang Khoa", 22, "Hue"));
        employeeMap.put("002", new Employee("2", "Hoang Le Quang", 28, "Da Nang"));
        employeeMap.put("003", new Employee("3", "Nguyen Thi Tuong Vi", 18, "Trum Tran Cao Van"));
        employeeMap.put("004", new Employee("4", "Tran Hoang Sang", 25, "Trum Me Nhu"));
        employeeMap.put("005", new Employee("5", "Tran Quoc Hoang", 26, "Quang Nam"));
        employeeMap.put("006", new Employee("6", "Le Van Quang", 28, "Quang Nam"));
        employeeMap.put("007", new Employee("7", "Nguyen Hoang Bao Ngoc", 24, "Hue"));
        employeeMap.put("008", new Employee("8", "Nguyen Ngoc Dong", 36, "Trum Nguyen Van Linh"));
        employeeMap.put("009", new Employee("9", "Cai Van", 24, "Trum Quang Binh"));
        employeeMap.put("010", new Employee("10", "Nguyen Ngoc Thuan", 23, "Trum Hue"));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeMap.values());
    }
}
