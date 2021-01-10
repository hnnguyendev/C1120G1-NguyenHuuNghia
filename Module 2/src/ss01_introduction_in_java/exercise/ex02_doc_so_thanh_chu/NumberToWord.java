package ss01_introduction_in_java.exercise.ex02_doc_so_thanh_chu;

import java.util.Scanner;

public class NumberToWord {

    static int number;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        number = scanner.nextInt();
    }

    static void readZeroToNine(int anyNumber) {
        String numberStr = "";
        switch (anyNumber) {
            case 0:
                numberStr = "zero";
                break;
            case 1:
                numberStr = "one";
                break;
            case 2:
                numberStr = "two";
                break;
            case 3:
                numberStr = "three";
                break;
            case 4:
                numberStr = "four";
                break;
            case 5:
                numberStr = "five";
                break;
            case 6:
                numberStr = "six";
                break;
            case 7:
                numberStr = "seven";
                break;
            case 8:
                numberStr = "eight";
                break;
            case 9:
                numberStr = "nine";
                break;
            default:
                numberStr = "";
                break;
        }

        if (numberStr != "") {
            System.out.printf("%s", numberStr);
        } else {
            System.out.println("Out of ability");
        }
    }

    static void readTenToNineteen(int anyNumber) {
        int ones = anyNumber % 10;
        String onesStr = "";
        String suffix = "teen";
        switch (ones) {
            case 0:
                onesStr = "ten";
                break;
            case 1:
                onesStr = "eleven";
                break;
            case 2:
                onesStr = "twelve";
                break;
            case 3:
                onesStr = "thir" + suffix;
                break;
            case 4:
                onesStr = "four" + suffix;
                break;
            case 5:
                onesStr = "fif" + suffix;
                break;
            case 6:
                onesStr = "six" + suffix;
                break;
            case 7:
                onesStr = "seven" + suffix;
                break;
            case 8:
                onesStr = "eight" + suffix;
                break;
            case 9:
                onesStr = "nine" + suffix;
                break;
            default:
                onesStr = "";
                break;
        }

        if (onesStr != "") {
            System.out.printf("%s", onesStr);
        } else {
            System.out.println("Out of ability");
        }
    }

    static void readTwentyToNinetyNine(int anyNumber) {
        int tens = anyNumber / 10;
        int ones = anyNumber % 10;
        String tensStr = "";
        String onesStr = "";
        switch (tens) {
            case 2:
                tensStr = "twenty";
                break;
            case 3:
                tensStr = "thirty";
                break;
            case 4:
                tensStr = "forty";
                break;
            case 5:
                tensStr = "fifty";
                break;
            case 6:
                tensStr = "sixty";
                break;
            case 7:
                tensStr = "seventy";
                break;
            case 8:
                tensStr = "eighty";
                break;
            case 9:
                tensStr = "ninety";
                break;
            default:
                tensStr = "";
                break;
        }

        switch (ones) {
            case 0:
                onesStr = " ";
                break;
            case 1:
                onesStr = "one";
                break;
            case 2:
                onesStr = "two";
                break;
            case 3:
                onesStr = "three";
                break;
            case 4:
                onesStr = "four";
                break;
            case 5:
                onesStr = "five";
                break;
            case 6:
                onesStr = "six";
                break;
            case 7:
                onesStr = "seven";
                break;
            case 8:
                onesStr = "eight";
                break;
            case 9:
                onesStr = "nine";
                break;
            default:
                onesStr = "";
                break;
        }

        if (tensStr != "" && onesStr != "") {
            System.out.printf("%s %s", tensStr, onesStr);
        } else {
            System.out.println("Out of ability");
        }
    }

    static void readHundred(int anyNumber) {
        int hundreds = anyNumber / 100;
        int ten = (anyNumber - (hundreds * 100));
        int tens = ten / 10;
        int ones = ten % 10;
        String hundredsStr = "";
        String tensStr = "";
        String onesStr = "";

        switch (hundreds) {
            case 1:
                hundredsStr = "one";
                break;
            case 2:
                hundredsStr = "two";
                break;
            case 3:
                hundredsStr = "three";
                break;
            case 4:
                hundredsStr = "four";
                break;
            case 5:
                hundredsStr = "five";
                break;
            case 6:
                hundredsStr = "six";
                break;
            case 7:
                hundredsStr = "seven";
                break;
            case 8:
                hundredsStr = "eight";
                break;
            case 9:
                hundredsStr = "nine";
                break;
            default:
                hundredsStr = "";
                break;
        }

        switch (tens) {
            case 2:
                tensStr = "twenty";
                break;
            case 3:
                tensStr = "thirty";
                break;
            case 4:
                tensStr = "forty";
                break;
            case 5:
                tensStr = "fifty";
                break;
            case 6:
                tensStr = "sixty";
                break;
            case 7:
                tensStr = "seventy";
                break;
            case 8:
                tensStr = "eighty";
                break;
            case 9:
                tensStr = "ninety";
                break;
            default:
                tensStr = "";
                break;
        }

        switch (ones) {
            case 0:
                onesStr = " ";
                break;
            case 1:
                onesStr = "one";
                break;
            case 2:
                onesStr = "two";
                break;
            case 3:
                onesStr = "three";
                break;
            case 4:
                onesStr = "four";
                break;
            case 5:
                onesStr = "five";
                break;
            case 6:
                onesStr = "six";
                break;
            case 7:
                onesStr = "seven";
                break;
            case 8:
                onesStr = "eight";
                break;
            case 9:
                onesStr = "nine";
                break;
            default:
                onesStr = "";
                break;
        }

        if (hundredsStr != "" || tensStr != "" || onesStr != "") {
            if (anyNumber % 100 == 0) {
                System.out.printf("%s hundred", hundredsStr);
            } else {
                System.out.printf("%s hundred and %s %s", hundredsStr, tensStr, onesStr);
            }
        } else {
            System.out.println("Out of ability");
        }
    }

    public static void main(String[] args) {
        input();
        if (number >= 0 && number < 10) {
            readZeroToNine(number);
        } else if (number >= 10 && number < 20) {
            readTenToNineteen(number);
        } else if (number >= 20 && number < 100) {
            readTwentyToNinetyNine(number);
        } else if (number >= 100 && number < 1000) {
            readHundred(number);
        }
    }

}
