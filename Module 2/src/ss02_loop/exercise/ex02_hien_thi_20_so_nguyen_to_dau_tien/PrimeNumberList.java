package ss02_loop.exercise.ex02_hien_thi_20_so_nguyen_to_dau_tien;

import java.util.Scanner;

public class PrimeNumberList {

    static int number;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many primes do you want:");
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
        int count = 0;
        int i = 2;
        while (count < number) {
            if (isPrimeNumber(i)) {
                count++;
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
