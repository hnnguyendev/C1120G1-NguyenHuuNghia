package ss11_map_tree.practice.p02_phan_biet_hashmap_va_hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("Mary", 15, "Manchester");
        Student student2 = new Student("Peter", 19, "New York");
        Student student3 = new Student("Alexa", 20, "Oslo");
        Student student4 = new Student("John", 29, "London");
        Student student5 = new Student("William", 24, "Stockholm");

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, student1);
        studentMap.put(2, student2);
        studentMap.put(3, student3);
        studentMap.put(4, student4);
        studentMap.put(5, student5);

        Set<Integer> keySet = studentMap.keySet();
        for (Integer key : keySet) {
            System.out.println(studentMap.get(key));
        }

        for(Map.Entry<Integer, Student> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student4);
        studentSet.add(student5);

        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
}
