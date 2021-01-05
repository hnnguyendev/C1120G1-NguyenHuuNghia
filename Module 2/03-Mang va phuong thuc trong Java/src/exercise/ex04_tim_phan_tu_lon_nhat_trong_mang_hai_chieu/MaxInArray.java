package exercise.ex04_tim_phan_tu_lon_nhat_trong_mang_hai_chieu;

import java.util.Scanner;

public class MaxInArray {

//	public static int[][] array = { { 1, 5, 4, 8, 9 }, { 7, 12, 24, 78, 0 }, { 22, 33, 44, 55, 66 } };
	public static int row;
	public static int column;
	public static int[][] array;

	public static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter row:");
			row = scanner.nextInt();
			if (row > 20) {
				System.out.println("Row does not exceed 20");
			}
		} while (row > 20);
		do {
			System.out.println("Enter column:");
			column = scanner.nextInt();
			if (column > 20) {
				System.out.println("Column does not exceed 20");
			}
		} while (column > 20);

		array = new int[row][column];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print("Enter element [" + i + "][" + j + "]: ");
				array[i][j] = scanner.nextInt();
			}
		}
	}

	public static void findMaxInArray() {
		int max = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (max < array[i][j]) {
					max = array[i][j];
				}
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		input();
		findMaxInArray();
	}

}
