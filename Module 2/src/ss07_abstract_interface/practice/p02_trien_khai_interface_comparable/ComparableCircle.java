package ss07_abstract_interface.practice.p02_trien_khai_interface_comparable;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (this.getRadius() > o.getRadius()) {
            return 1;
        } else if (this.getRadius() < o.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
