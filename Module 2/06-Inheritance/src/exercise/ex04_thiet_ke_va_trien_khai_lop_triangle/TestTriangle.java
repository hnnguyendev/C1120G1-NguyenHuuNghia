package exercise.ex04_thiet_ke_va_trien_khai_lop_triangle;

import java.util.Scanner;

public class TestTriangle {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter side a:");
		double side1 = scanner.nextDouble();
		System.out.println("Enter side b:");
		double side2 = scanner.nextDouble();
		System.out.println("Enter side c:");
		double side3 = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter triangle color:");
		String color = scanner.nextLine();
		Triangle triangle = new Triangle(color, true, side1, side2, side3);
		System.out.println(triangle);

	}

}
