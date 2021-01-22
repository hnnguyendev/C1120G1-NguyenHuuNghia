package ss14_exception_handling_debug.exercise.ex01_su_dung_lop_illegaltriangleexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException(String message) {
        super(message);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = null;

        while (triangle == null) {
            try {
                System.out.print("Enter side a: ");
                int sideA = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter side b: ");
                int sideB = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter side c: ");
                int sideC = Integer.parseInt(scanner.nextLine());
                triangle = new Triangle(sideA, sideB, sideC);
            } catch (IllegalTriangleException e) {
                System.out.println("ba canh loi " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("khong hop le " + e.getMessage());
            }
        }

        System.out.println("KET THUC " + triangle);

    }
}
