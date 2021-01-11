package ss07_abstract_interface.exercise.ex01_trien_khai_interface_resizeable;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Circle;

public class ResizeableCircle extends Circle implements IResizeable {

    public ResizeableCircle() {
    }

    public ResizeableCircle(double radius) {
        super(radius);
    }

    public ResizeableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public void resize(double percent) {
        this.setRadius(Math.sqrt((this.getArea() + this.getArea() * percent / 100) / Math.PI));
    }
}
