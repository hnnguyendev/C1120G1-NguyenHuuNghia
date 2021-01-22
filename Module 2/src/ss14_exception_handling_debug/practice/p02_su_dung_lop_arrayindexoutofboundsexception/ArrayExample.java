package ss14_exception_handling_debug.practice.p02_su_dung_lop_arrayindexoutofboundsexception;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArrayExample {

    public int[] createRandom() {

        Random rd = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        int[] arr = arrayExample.createRandom();

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println("Element " + arr[index] + " at position " + index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (InputMismatchException e) {
            System.out.println("Input mis match");
        }

    }
}
