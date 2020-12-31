package practice.p07_chi_so_can_nang_cua_co_the;

import java.util.Scanner;

public class BodyMassIndex {

	static double weight;
	static double height;
	static double bmi;

	static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your weight (kg):");
		weight = scanner.nextDouble();
		System.out.println("Enter your height (m):");
		height = scanner.nextDouble();
	}

	/**
	 * (-20): neu so chu so cua bmi < 20 thi them space vao ben phai
	 * (%.2f): gia tri bmi chi lay hai chu so thap phan
	 */
	static void calBMI() {
		bmi = weight / Math.pow(height, 2);

		System.out.printf("%-20s%s", "BMI", "Interpretation\n");
		if (bmi < 18.5) {
			System.out.printf("%-20.2f%s", bmi, "Underweight");
		} else if (bmi < 25.0) {
			System.out.printf("%-20.2f%s", bmi, "Normal");
		} else if (bmi < 30.0) {
			System.out.printf("%-20.2f%s", bmi, "Overweight");
		} else {
			System.out.printf("%-20.2f%s", bmi, "Obese");
		}
	}

	public static void main(String[] args) {
		input();
		calBMI();

	}

}
