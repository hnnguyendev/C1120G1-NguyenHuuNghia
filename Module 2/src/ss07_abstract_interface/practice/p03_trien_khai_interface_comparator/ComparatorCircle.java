package ss07_abstract_interface.practice.p03_trien_khai_interface_comparator;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Circle;

import java.util.Comparator;

public class ComparatorCircle implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) {
            return 1;
        } else if (c1.getRadius() < c2.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
