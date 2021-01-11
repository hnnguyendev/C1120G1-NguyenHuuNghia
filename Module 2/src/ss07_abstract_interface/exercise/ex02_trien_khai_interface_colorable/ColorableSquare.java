package ss07_abstract_interface.exercise.ex02_trien_khai_interface_colorable;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Square;

public class ColorableSquare extends Square implements IColorable {

    public ColorableSquare() {
    }

    public ColorableSquare(double side) {
        super(side);
    }

    public ColorableSquare(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
