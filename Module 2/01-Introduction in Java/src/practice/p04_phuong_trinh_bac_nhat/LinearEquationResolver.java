package practice.p04_phuong_trinh_bac_nhat;

import java.util.Scanner;

public class LinearEquationResolver {

	static double a;
	static double b;

	static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("a: ");
		a = scanner.nextDouble();
		System.out.print("b: ");
		b = scanner.nextDouble();
	}

	static void solveLinearEquation() {
		System.out.println("Linear Equation Resolver");
		System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
		input();
		if (a != 0) {
			double solution = -b / a;
			System.out.printf("Equation pass with x = %.1f!", solution);
		} else if (b == 0) {
			System.out.println("The solution is all x");
		} else {
			System.out.println("No solution!");
		}
	}

	public static void main(String[] args) {
		solveLinearEquation();

	}

}
