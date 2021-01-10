package ss03_array_and_method.practice.p01_dao_nguoc_cac_phan_tu_cua_mang;

import java.util.Scanner;

public class ReverseArray {

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
		int i = 0;
		
		while (i < array.length) {
			System.out.print("Enter element " + (i + 1) + ": ");
			array[i] = scanner.nextInt();
			i++;
		}
	}

	public static int[] reverseArray(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[size - 1 - i];
			array[size - 1 - i] = temp;
		}
		return array;
	}

	public static void output(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}

	public static void main(String[] args) {
		input();
		System.out.print("Elements in array: ");
		output(array);
		reverseArray(array);
		System.out.print("Reverse array: ");
		output(array);
	}

}
