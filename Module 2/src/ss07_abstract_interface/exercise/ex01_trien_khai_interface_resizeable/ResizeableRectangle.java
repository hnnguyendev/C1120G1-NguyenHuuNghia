package ss07_abstract_interface.exercise.ex01_trien_khai_interface_resizeable;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Rectangle;

public class ResizeableRectangle extends Rectangle implements IResizeable {

    public ResizeableRectangle() {
    }

    public ResizeableRectangle(double width, double height) {
        super(width, height);
    }

    public ResizeableRectangle(String color, boolean filled, double width, double height) {
        super(color, filled, width, height);
    }

    @Override
    public void resize(double percent) {
        this.setWidth(this.getWidth() + this.getWidth() * percent / 2 / 100);
        this.setHeight(this.getHeight() + this.getHeight() * percent / 2 / 100);
    }
}
