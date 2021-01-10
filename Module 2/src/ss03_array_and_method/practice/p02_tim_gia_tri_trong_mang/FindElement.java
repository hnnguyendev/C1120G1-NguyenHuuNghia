package ss03_array_and_method.practice.p02_tim_gia_tri_trong_mang;

import java.util.Scanner;

public class FindElement {

	public static String studentName;
	public static String[] students = { "Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah",
			"Mallory", "Zoe", "Emily" };

	public static void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student name:");
		studentName = scanner.nextLine();
	}

	public static void findStudent(String name, String[] array) {
		boolean isExist = false;
		int position = 0;
		int i;
		for (i = 0; i < array.length; i++) {
			if (name.equals(array[i])) {
				isExist = true;
				position = i;
				break;
			}
		}
		if (isExist) {
			System.out.println(array[i] + " at position is: " + position);
		} else {
			System.out.println("Student " + studentName + " does not exist!");
		}
	}

	public static void main(String[] args) {
		input();
		findStudent(studentName, students);

	}

}
