package ss13_sorting_algorithm.practice.p01_minh_hoa_thuat_toan_sap_xep_noi_bot;

import java.util.Scanner;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        boolean isNextPass = true;
        for (int i = 1; i < arr.length && isNextPass; i++) {
            isNextPass = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = scanner.nextInt();
        int[] numArray = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numArray[i] = scanner.nextInt();
        }

        System.out.print("Pre-sort: ");
        for (int element : numArray) {
            System.out.print(element + " ");
        }
        System.out.println();

        bubbleSort(numArray);

        System.out.print("After-sort: ");
        for (int element : numArray) {
            System.out.print(element + " ");
        }
    }
}
