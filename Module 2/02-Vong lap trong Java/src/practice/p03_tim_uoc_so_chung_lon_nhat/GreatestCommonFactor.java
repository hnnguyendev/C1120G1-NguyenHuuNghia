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

	static int findGreatestCommonFactor(int numberA, int numberB) {
		numberA = Math.abs(numberA);
		numberB = Math.abs(numberB);
		if (numberA == 0 || numberB == 0) {
			return numberA + numberB;
		}
		while (numberA != numberB) {
			if (numberA > numberB)
				numberA -= numberB;
			else
				numberB -= numberA;
		}
		return numberA;

	}

	public static void main(String[] args) {
		input();
		System.out.println(findGreatestCommonFactor(numberA, numberB));

	}

}
