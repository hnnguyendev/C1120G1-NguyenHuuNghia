package ss13_sorting_algorithm.exercise.ex01_cai_dat_thuat_toan_sap_xep_chen;

public class InsertionSort {

    static int[] numArray = {1, 9, 4, 6, 5, -4};

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > currentElement; j--) {
                arr[j + 1] = arr[j];
            }
            // luc nay j da bi tru di 1
            arr[j + 1] = currentElement;
        }

    }

    public static void main(String[] args) {
        insertionSort(numArray);
        for (int element : numArray) {
            System.out.print(element + " ");
        }
    }
}
