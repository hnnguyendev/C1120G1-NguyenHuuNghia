package ss12_searching_algorithm.practice.p02_cai_dat_thuat_toan_tim_kiem_nhi_phan_su_dung_de_quy;

public class BinarySearch {

    static int[] numArray = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static int binarySearch(int[] arr, int low, int high, int value) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value > arr[mid]) {
                return binarySearch(arr, mid + 1, high, value);
            } else {
                return binarySearch(arr, low, mid - 1, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(numArray, 0, numArray.length - 1, 2));
        System.out.println(binarySearch(numArray, 0, numArray.length - 1, 11));
        System.out.println(binarySearch(numArray, 0, numArray.length - 1, 79));
        System.out.println(binarySearch(numArray, 0, numArray.length - 1, 1));
        System.out.println(binarySearch(numArray, 0, numArray.length - 1, 5));
        System.out.println(binarySearch(numArray, 0, numArray.length - 1, 80));
    }
}
