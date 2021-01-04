package practice.p02_tinh_tien_lai_cho_vay;

import java.util.Scanner;

public class InterestCalculation {

	static double money;
	static double interestRate;
	static int month;

	static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter investment amount:");
		money = scanner.nextDouble();
		System.out.println("Enter annual interest rate in percentage:");
		interestRate = scanner.nextDouble();
		System.out.println("Enter number of months:");
		month = scanner.nextInt();
	}

	static double calInterest(double money, double interestRate, int month) {
		double totalInterest = 0;
		for (int i = 0; i < month; i++) {
			totalInterest += money * (interestRate / 100) / 12 * month;
		}
		return totalInterest;
	}

	public static void main(String[] args) {
		input();
		System.out.println("Total of interset: " + calInterest(money, interestRate, month) + " VND");

	}

}
