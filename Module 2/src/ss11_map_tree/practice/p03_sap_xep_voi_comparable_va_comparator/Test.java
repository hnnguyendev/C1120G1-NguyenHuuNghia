package ss11_map_tree.practice.p03_sap_xep_voi_comparable_va_comparator;

import ss11_map_tree.practice.p02_phan_biet_hashmap_va_hashset.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Mary", 15, "Manchester");
        Student student2 = new Student("Peter", 19, "New York");
        Student student3 = new Student("Alexa", 20, "Oslo");
        Student student4 = new Student("John", 29, "London");
        Student student5 = new Student("William", 24, "Stockholm");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        System.out.println("Pre-sort: ");
        for (Student student : studentList) {
            System.out.println(student);
        }

        Collections.sort(studentList);

        System.out.println("After-sort: ");
        for (Student student : studentList) {
            System.out.println(student);
        }

        Collections.sort(studentList, new AgeComparator());
        System.out.println("After-sort by age: ");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
