package ss14_exception_handling_debug.practice.p03_su_dung_lop_numberformatexception;

import java.util.Scanner;

public class CalculationExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x: ");
        int numX = scanner.nextInt();
        System.out.println("Enter y: ");
        int numY = scanner.nextInt();
        CalculationExample calc = new CalculationExample();
        calc.calculate(numX, numY);

    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Sum x + y = " + a);
            System.out.println("Subtract x - y = " + b);
            System.out.println("Multi x * y = " + c);
            System.out.println("Divide x / y = " + d);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
