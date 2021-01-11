package ss07_abstract_interface.practice.p03_trien_khai_interface_comparator;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(2);
        circles[1] = new Circle();
        circles[2] = new Circle("red", false, 5);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator circleComparator = new ComparatorCircle();

        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
