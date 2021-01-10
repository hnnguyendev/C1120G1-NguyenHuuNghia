package ss01_introduction_in_java.practice.p03_su_dung_toan_tu;

import java.util.Scanner;

public class RectangleProgram {

    static float width;
    static float height;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width:");
        width = scanner.nextFloat();
        System.out.println("Enter the height:");
        height = scanner.nextFloat();
    }

    static void calRectangleArea() {
        input();
        float area = width * height;
        System.out.println("Area = " + area);
    }

    public static void main(String[] args) {
        calRectangleArea();

    }

}
