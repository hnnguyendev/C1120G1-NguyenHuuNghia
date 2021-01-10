package ss03_array_and_method.exercise.ex01_xoa_phan_tu_khoi_mang;

import java.util.Scanner;

public class DeleteElement {

	public static int[] array = { 8, 9, 7, 2, 5, 1, 12, 6, 4, 11 };
	public static int element;

	public static void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter element you want to delete: ");
		element = scanner.nextInt();
	}

	public static boolean deleteElement(int element) {
		for (int i = 0; i < array.length; i++) {
			if (element == array[i]) {
				for (int j = i; j < array.length - 1; j++) {
					array[j] = array[j + 1];
				}
				array[array.length - 1] = 0;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		input();
		if (deleteElement(element)) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");

			}

		} else {
			System.out.println(element + " does not exist in array");
		}

	}

}
