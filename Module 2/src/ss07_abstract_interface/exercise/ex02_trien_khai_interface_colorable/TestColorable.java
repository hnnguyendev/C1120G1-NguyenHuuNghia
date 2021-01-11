package ss07_abstract_interface.exercise.ex02_trien_khai_interface_colorable;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Circle;
import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Rectangle;
import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Shape;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(20, 10);
        shapes[2] = new ColorableSquare(10);

        for (Shape shape : shapes) {
            if (shape instanceof ColorableSquare) {
                IColorable iColorable = (ColorableSquare) shape;
                iColorable.howToColor();
            }
        }
    }
}
