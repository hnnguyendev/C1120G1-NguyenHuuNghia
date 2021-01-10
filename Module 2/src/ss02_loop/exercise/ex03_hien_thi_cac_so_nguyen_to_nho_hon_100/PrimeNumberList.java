package ss02_loop.exercise.ex03_hien_thi_cac_so_nguyen_to_nho_hon_100;

import java.util.Scanner;

public class PrimeNumberList {

    static int number;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your limit:");
        number = scanner.nextInt();
    }

    static boolean isPrimeNumber(int anyNumber) {
        if (anyNumber < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(anyNumber); i++) {
            if (anyNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void listPrimeNumber(int number) {
        int i = 2;
        while (i < number) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
            i++;
        }
    }

    public static void main(String[] args) {
        input();
        listPrimeNumber(number);

    }

}
