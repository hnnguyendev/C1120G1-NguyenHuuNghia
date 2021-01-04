package practice.p03_tim_uoc_so_chung_lon_nhat;

import java.util.Scanner;

public class GreatestCommonFactor {

	static int numberA;
	static int numberB;

	static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number A:");
		numberA = scanner.nextInt();
		System.out.println("Enter number B:");
		numberB = scanner.nextInt();
	}

	static void findGreatestCommonFactor() {
		numberA = Math.abs(numberA);
		numberB = Math.abs(numberB);
		if (numberA == 0 || numberA == 0)
			System.out.println("No greatest common factor");
		while (numberA != numberB) {
			if (numberA > numberB)
				numberA = numberA - numberB;
			else
				numberB = numberB - numberA;
		}
		System.out.println("Greatest common factor: " + numberA);

	}

	public static void main(String[] args) {
		input();
		findGreatestCommonFactor();

	}

}
