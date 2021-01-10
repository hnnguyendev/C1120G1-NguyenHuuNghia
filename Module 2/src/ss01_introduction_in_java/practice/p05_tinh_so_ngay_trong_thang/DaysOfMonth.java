package ss01_introduction_in_java.practice.p05_tinh_so_ngay_trong_thang;

import java.util.Scanner;

public class DaysOfMonth {

    static int month;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which month that you want to count days?");
        month = scanner.nextInt();
    }

    static void countDaysOfMonth() {
        input();
        String daysOfMonth = "";
        switch (month) {
            case 2:
                daysOfMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysOfMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysOfMonth = "30";
                break;
            default:
                System.out.println("");
        }

        if (daysOfMonth != "") {
            System.out.printf("The month '%d' has %s days!", month, daysOfMonth);
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static void main(String[] args) {
        countDaysOfMonth();

    }

}
