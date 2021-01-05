package practice.p06_dem_so_luong_sinh_vien_thi_do;

import java.util.Scanner;

public class StudentPass {

	public static int size;
	public static int[] students;

	public static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter quantity of student:");
			size = scanner.nextInt();
			if (size > 30) {
				System.out.println("Quantity should not exceed 30");
			}
		} while (size > 30);

		students = new int[size];

		for (int i = 0; i < students.length; i++) {
			do {
				System.out.print("Enter a score for student " + (i + 1) + ": ");
				students[i] = scanner.nextInt();
			} while (students[i] < 0 || students[i] > 10);
		}
	}

	public static void calStudentsPass() {
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			System.out.print(students[i] + " ");
			if (students[i] >= 5) {
				count++;
			}
		}
		System.out.println("\nHave " + count + " students pass");
	}

	public static void main(String[] args) {
		input();
		calStudentsPass();
	}

}
