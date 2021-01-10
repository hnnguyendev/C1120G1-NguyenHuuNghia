package ss03_array_and_method.exercise.ex05_tim_gia_tri_nho_nhat_trong_mang;

import java.util.Scanner;

public class FindMinInArray {

	public static int size;
	public static int[] array;

	public static void input() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter size of array:");
			size = scanner.nextInt();
			if (size > 20) {
				System.out.println("Size does not exceed 20");
			}
		} while (size > 20);

		array = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter element " + (i + 1) + ": ");
			array[i] = scanner.nextInt();
		}
	}

	public static void findMinInArray() {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		System.out.println(min);
	}

	public static void main(String[] args) {
		input();
		findMinInArray();

	}

}
