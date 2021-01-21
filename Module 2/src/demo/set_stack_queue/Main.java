package demo.set_stack_queue;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
//        Set<String> listStringSet = new TreeSet<>();
//        listStringSet.add("Java");
//        listStringSet.add("Android");
//        listStringSet.add("PHP");
//        listStringSet.add("Java");
//        listStringSet.add("C#");
//        listStringSet.add("C++");
//        listStringSet.add("Python");
//        for (String str : listStringSet) {
//            System.out.println(str);
//        }

        Set<Student> setStudent = new HashSet<>();
        setStudent.add(new Student(1, "Peter", 33));
        setStudent.add(new Student(2, "Peter2", 33));
        setStudent.add(new Student(3, "Peter3", 33));
        setStudent.add(new Student(4, "Peter4", 33));
        setStudent.add(new Student(1, "Peter", 33));
        setStudent.add(new Student(5, "Peter6", 33));
        for (Student student : setStudent) {
            System.out.println(student);
        }

    }
}
