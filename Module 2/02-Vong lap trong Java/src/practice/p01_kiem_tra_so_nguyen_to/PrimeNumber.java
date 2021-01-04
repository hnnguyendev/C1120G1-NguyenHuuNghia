package practice.p01_kiem_tra_so_nguyen_to;

import java.util.Scanner;

public class PrimeNumber {

	static int number;

	static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number:");
		number = scanner.nextInt();
	}

	static boolean isPrimeNumber(int anyNumber) {
		if (anyNumber < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(anyNumber); i++) {
			if (anyNumber % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		input();
		System.out.println(isPrimeNumber(number));

	}

}
