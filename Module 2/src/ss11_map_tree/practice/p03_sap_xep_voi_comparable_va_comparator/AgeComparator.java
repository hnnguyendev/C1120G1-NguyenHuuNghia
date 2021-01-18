package ss11_map_tree.practice.p03_sap_xep_voi_comparable_va_comparator;

import ss11_map_tree.practice.p02_phan_biet_hashmap_va_hashset.Student;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
