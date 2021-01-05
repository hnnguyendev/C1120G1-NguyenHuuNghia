package practice.p05_tim_gia_tri_nho_nhat_trong_mang;

import java.util.Scanner;

public class FindMin {

	public static int size;
	public static int[] array;

	public static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter size of array:");
			size = scanner.nextInt();
			if (size > 20) {
				System.out.println("Size does not exceed 20");
			}
		} while (size > 20);

		array = new int[size];
		int i = 0;

		while (i < array.length) {
			System.out.print("Enter element " + (i + 1) + ": ");
			array[i] = scanner.nextInt();
			i++;
		}
	}

	public static int findMin(int[] arr) {
		int min = arr[0];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		input();
		System.out.println("The smallest element in the array is: " + array[findMin(array)]);

	}

}
