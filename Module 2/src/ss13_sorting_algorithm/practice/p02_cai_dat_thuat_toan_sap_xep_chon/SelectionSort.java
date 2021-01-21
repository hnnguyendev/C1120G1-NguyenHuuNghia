package ss13_sorting_algorithm.practice.p02_cai_dat_thuat_toan_sap_xep_chon;

public class SelectionSort {

    static int[] numArray = {1, 9, 4, 6, 5, -4};

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < numArray.length - 1; i++) {
            int currentMin = numArray[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[j] < currentMin) {
                    currentMin = numArray[j];
                    currentMinIndex = j;
                }
            }
            if (i != currentMinIndex) {
                numArray[currentMinIndex] = numArray[i];
                numArray[i] = currentMin;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(numArray);
        for (int element : numArray) {
            System.out.print(element + " ");
        }
    }
}
