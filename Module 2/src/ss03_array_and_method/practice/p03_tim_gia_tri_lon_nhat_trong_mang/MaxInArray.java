package ss03_array_and_method.practice.p03_tim_gia_tri_lon_nhat_trong_mang;

import java.util.Scanner;

public class MaxInArray {

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

		int i = 0;
		array = new int[size];

		while (i < array.length) {
			System.out.print("Enter element " + (i + 1) + ": ");
			array[i] = scanner.nextInt();
			i++;
		}

	}

	public static void findMax() {
		int max = array[0];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				index = i;
			}
		}
		System.out.println("The largest property value in the list is " + max + ", at position " + index);
	}

	public static void main(String[] args) {
		input();
		findMax();

	}

}
