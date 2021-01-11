package ss07_abstract_interface.exercise.ex01_trien_khai_interface_resizeable;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Square;

public class ResizeableSquare extends Square implements IResizeable {

    public ResizeableSquare() {
    }

    public ResizeableSquare(double side) {
        super(side);
    }

    public ResizeableSquare(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    @Override
    public void resize(double percent) {
        this.setSide(Math.sqrt(this.getArea() + getArea() * percent / 100));
    }
}
