package exercise.ex06_tinh_tong_cac_so_o_mot_cot_xac_dinh;

import java.util.Scanner;

public class SumOfColumn {

//	public static int[][] array = { { 1, 5, 4, 8, 9 }, { 7, 12, 24, 78, 0 }, { 22, 33, 44, 55, 66 } };
	public static int choiceColumn;
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
		do {
			System.out.println("Enter the column you want to calSum:");
			choiceColumn = scanner.nextInt();
		} while (choiceColumn < 0 || choiceColumn > array[1].length - 1);
	}

	public static int calSumOfColumn(int[][] arr, int column) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][column];
		}
		return sum;
	}

	public static void main(String[] args) {
		input();
		System.out.println(calSumOfColumn(array, choiceColumn));

	}

}
