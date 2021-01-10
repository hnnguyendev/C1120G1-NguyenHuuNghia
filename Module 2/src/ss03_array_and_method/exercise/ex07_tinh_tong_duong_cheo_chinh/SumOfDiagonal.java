package ss03_array_and_method.exercise.ex07_tinh_tong_duong_cheo_chinh;

import java.util.Scanner;

public class SumOfDiagonal {

//	public static int[][] array = { { 1, 5, 4 }, { 7, 12, 24 }, { 22, 33, 44 } };
	public static int side;
	public static int[][] array;

	public static void input() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter size of array:");
			side = scanner.nextInt();
			if (side > 20) {
				System.out.println("Row does not exceed 20");
			}
		} while (side > 20);

		array = new int[side][side];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print("Enter element [" + i + "][" + j + "]: ");
				array[i][j] = scanner.nextInt();
			}
		}
	}

	public static int calSumOfDiagonal(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][i];
		}
		return sum;
	}

	public static void main(String[] args) {
		input();
		System.out.println(calSumOfDiagonal(array));
	}

}
