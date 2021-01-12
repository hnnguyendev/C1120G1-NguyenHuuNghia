package ss07_abstract_interface.exercise.ex01_trien_khai_interface_resizeable;

import ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc.Shape;

import java.util.Random;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new ResizeableCircle(3);
        shapes[1] = new ResizeableRectangle(20, 10);
        shapes[2] = new ResizeableSquare(10);

        Random random = new Random();

        for (Shape shape : shapes) {
            System.out.println("Pre-resize:");
            int percent = random.nextInt(99) + 1;

            if (shape instanceof ResizeableCircle) {
                ResizeableCircle resizeableCircle = (ResizeableCircle) shape;
                IResizeable iResizeable = (ResizeableCircle) shape;
                System.out.println("Area = " + resizeableCircle.getArea());
                System.out.println("Increase percent: " + percent + "%");
                iResizeable.resize(percent);
                System.out.println("After-resize:\nArea = " + resizeableCircle.getArea());
            } else if (shape instanceof ResizeableRectangle) {
                ResizeableRectangle resizeableRectangle = (ResizeableRectangle) shape;
                IResizeable iResizeable = (ResizeableRectangle) shape;
                System.out.println("Area = " + resizeableRectangle.getArea());
                System.out.println("Increase percent: " + percent + "%");
                iResizeable.resize(percent);
            } else {
                ResizeableSquare resizeableSquare = (ResizeableSquare) shape;
                IResizeable iResizeable = (ResizeableSquare) shape;
                System.out.println("Area = " + resizeableSquare.getArea());
                System.out.println("Increase percent: " + percent + "%");
                iResizeable.resize(percent);
                System.out.println("After-resize:\nArea = " + resizeableSquare.getArea());
            }
            System.out.println("-----------------------------------");
        }
    }
}
