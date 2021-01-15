package ss10_set_stack_queue.exercise.ex04_to_chuc_du_lieu_hop_ly_demerging_su_dung_queue;

import java.util.*;

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Queue<Employee> maleQueue = new LinkedList<>();
        Queue<Employee> femaleQueue = new LinkedList<>();

        employeeList.add(new Employee("Peter", true, "11/11/2000"));
        employeeList.add(new Employee("Mary", false, "11/01/2000"));
        employeeList.add(new Employee("John", true, "07/07/1997"));
        employeeList.add(new Employee("William", true, "22/12/2001"));
        employeeList.add(new Employee("Alexa", false, "30/4/1975"));

        System.out.println("Pre-order:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        Collections.sort(employeeList, new CompaByBirthday());

        for (Employee employee : employeeList) {
            if (!employee.isGender()) {
                femaleQueue.add(employee);
            } else {
                maleQueue.add(employee);
            }
        }

        List<Employee> employeeListSorted = new ArrayList<>();
        employeeListSorted.addAll(femaleQueue);
        employeeListSorted.addAll(maleQueue);

        System.out.println("After-sort:");
        for (Employee element : employeeListSorted) {
            System.out.println(element);
        }
    }
}
