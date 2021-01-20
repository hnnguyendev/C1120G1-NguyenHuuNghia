package ss12_searching_algorithm.practice.p01_cai_dat_thuat_toan_tim_kiem_nhi_phan_khong_dung_de_quy;

public class BinarySearch {

    static int[] numArray = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(numArray, 2));  /* 0 */
        System.out.println(binarySearch(numArray, 11)); /* 4 */
        System.out.println(binarySearch(numArray, 79)); /*12 */
        System.out.println(binarySearch(numArray, 1));  /*-1 */
        System.out.println(binarySearch(numArray, 5));  /*-1 */
        System.out.println(binarySearch(numArray, 80)); /*-1 */
    }
}
