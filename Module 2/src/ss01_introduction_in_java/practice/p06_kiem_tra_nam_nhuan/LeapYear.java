package ss01_introduction_in_java.practice.p06_kiem_tra_nam_nhuan;

import java.util.Scanner;

public class LeapYear {

	static int year;

	static void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the year you want to check:");
		year = scanner.nextInt();
	}

	static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		input();
		if (isLeapYear(year)) {
			System.out.println(year + " is a leap year");
		} else {
			System.out.println(year + " is NOT a leap year");
		}

	}

}
