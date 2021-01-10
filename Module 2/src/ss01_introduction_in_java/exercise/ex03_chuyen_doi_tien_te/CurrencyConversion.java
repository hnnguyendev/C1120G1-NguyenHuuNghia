package ss01_introduction_in_java.exercise.ex03_chuyen_doi_tien_te;

import java.util.Scanner;

public class CurrencyConversion {

    static double usd;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD:");
        usd = scanner.nextDouble();
    }

    static void convertVndToUsd() {
        input();
        double rate = 23000;
        double result = usd * rate;
        System.out.println(usd + " USD = " + result + " VND");
    }

    public static void main(String[] args) {
        convertVndToUsd();

    }

}
