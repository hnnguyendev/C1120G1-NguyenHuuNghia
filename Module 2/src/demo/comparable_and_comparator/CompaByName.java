package demo.comparable_and_comparator;

import java.util.Comparator;

public class CompaByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
