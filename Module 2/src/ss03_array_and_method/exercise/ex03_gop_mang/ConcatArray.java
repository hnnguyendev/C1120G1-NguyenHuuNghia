package ss03_array_and_method.exercise.ex03_gop_mang;

public class ConcatArray {

	public static int[] array = { 8, 9, 7, 2, 5, 1, 12, 6, 4, 11 };
	public static int[] array2 = { 37, 19, 57, 22, 78 };
	public static int[] array3 = new int[array.length + array2.length];

	public static void concatArray() {
		for (int i = 0; i < array.length; i++) {
			array3[i] = array[i];
		}
		for (int i = 0; i < array2.length; i++) {
			array3[i + array.length] = array2[i];
		}
	}

	public static void main(String[] args) {
		concatArray();

		for (int element : array3) {
			System.out.print(element + " ");
		}

	}

}
