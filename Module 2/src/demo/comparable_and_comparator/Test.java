package demo.comparable_and_comparator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0]= new Student("Dong",34,"12/12/2000");
        students[1]= new Student("Khoa",43,"14/12/2000");
        students[2]= new Student("Vi",19,"12/12/2003");
        students[3]= new Student("Dong",24,"12/12/2005");
        students[4]= new Student("Van",21,"12/12/1999");
        System.out.println(" trước khi sx");
        for (Student student: students) {
            System.out.println(student.toString());
        }

//        Arrays.sort(students);
//
//        System.out.println(" sau  khi sx theo tuối");
//        for (Student student: students) {
//            System.out.println(student.toString());
//        }

//        Arrays.sort(students,new CompaByName());
//        System.out.println(" sau  khi sx theo tên");
//        for (Student student: students) {
//            System.out.println(student.toString());
//        }
//
//        Arrays.sort(students,new CompaByNameAndAge());
//        System.out.println(" sau  khi sx theo tên và tuổi");
//        for (Student student: students) {
//            System.out.println(student.toString());
//        }

        Arrays.sort(students, new CompaByBirthday());
        System.out.println(" sau  khi sx theo tên và tuổi");
        for (Student student: students) {
            System.out.println(student.toString());
        }
    }
}
