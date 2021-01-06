package exercise.ex01_xay_dung_lop_quadratic_equation;

import java.util.Scanner;

public class QuadraticEquation {

	private double numA;
	private double numB;
	private double numC;

	public QuadraticEquation() {
	}

	public QuadraticEquation(double numA, double numB, double numC) {
		this.numA = numA;
		this.numB = numB;
		this.numC = numC;
	}

	public double getNumA() {
		return numA;
	}

	public double getNumB() {
		return numB;
	}

	public double getNumC() {
		return numC;
	}

	public double getDiscriminant() {
		return Math.pow(numB, 2) - 4 * numA * numC;
	}

	public double getRoot1() {
		return (-numB - Math.sqrt(getDiscriminant())) / 2 / numA;
	}

	public double getRoot2() {
		return (-numB + Math.sqrt(getDiscriminant())) / 2 / numA;
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter num A:");
		double numA = scanner.nextDouble();
		System.out.println("Enter num B:");
		double numB = scanner.nextDouble();
		System.out.println("Enter num C:");
		double numC = scanner.nextDouble();

		QuadraticEquation quadraticEquation = new QuadraticEquation(numA, numB, numC);

		double numberA = quadraticEquation.getNumA();
		double numberB = quadraticEquation.getNumB();
		double numberC = quadraticEquation.getNumC();
		double delta = quadraticEquation.getDiscriminant();
		double root1 = quadraticEquation.getRoot1();
		double root2 = quadraticEquation.getRoot2();

		if (numberA == 0) {
			if (numberB == 0) {
				if (numberC == 0) {
					System.out.println("The equation has many roots");
				} else {
					System.out.println("The equation has no real roots");
				}
			} else {
				System.out.println("The equation has one root x = " + (-numberC / numberB));
			}
		} else {
			if (delta > 0) {
				System.out.println("The equation has two roots:");
				System.out.println("x1 = " + root1);
				System.out.println("x2 = " + root2);
			} else if (delta == 0) {
				System.out.println("The equation has one root:\nx = " + (-numberB / 2 / numberA));
			} else {
				System.out.println("The equation has no real roots");
			}
		}

	}

}
