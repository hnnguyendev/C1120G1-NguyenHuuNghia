package ss03_array_and_method.exercise.ex02_them_phan_tu_vao_mang;

import java.util.Scanner;

public class InsertElement {

	public static int element;
	public static int position = -1;
	public static int[] array = { 8, 9, 7, 2, 5, 1, 12, 6, 4, 11 };
	public static int[] newArray = new int[array.length + 1];

	public static void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a element you want to insert to the array:");
		element = scanner.nextInt();
		System.out.println("Enter index:");
		while (position < 0 || position > (array.length)) {
			position = scanner.nextInt();
		}
	}

	public static int[] insertElement(int element, int position) {
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		int length = array.length;
		while (position < length) {
			newArray[length] = newArray[length - 1];
			length--;
		}
		newArray[position] = element;

		return newArray;
	}

	public static void main(String[] args) {
		input();
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(insertElement(element, position)[i] + " ");
		}

	}

}
