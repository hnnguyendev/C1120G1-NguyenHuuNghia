package exercise.ex02_doc_so_thanh_chu;

import java.util.Scanner;

public class NumberToWordUpdate {

	static int number;

	static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number:");
		number = scanner.nextInt();
	}

	static String readOnes(int anyNumber) {
		String onesStr = "";
		switch (anyNumber) {
		case 0:
			onesStr = "zero";
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
		}
		return onesStr;
	}

	static String readTenToNineteen(int anyNumber) {
		int ones = anyNumber % 10;
		String numberStr = "";
		switch (ones) {
		case 0:
			numberStr = "ten";
			break;
		case 1:
			numberStr = "eleven";
			break;
		case 2:
			numberStr = "twelve";
			break;
		case 3:
			numberStr = "thirteen";
			break;
		case 4:
			numberStr = "fourteen";
			break;
		case 5:
			numberStr = "fifteen";
			break;
		case 6:
			numberStr = "sixteen";
			break;
		case 7:
			numberStr = "seventeen";
			break;
		case 8:
			numberStr = "eighteen";
			break;
		case 9:
			numberStr = "nineteen";
			break;
		}
		return numberStr;
	}

	static String readTens(int anyNumber) {
		String tensStr = "";
		switch (anyNumber) {
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
		}
		return tensStr;
	}

	static void convertToWord() {
		if (number >= 0 && number < 10) {
			System.out.println(readOnes(number));
		} else if (number >= 10 && number < 20) {
			System.out.println(readTenToNineteen(number));
		} else if (number >= 20 && number < 100) {
			int tens = number / 10;
			int ones = number % 10;
			if (ones == 0) {
				System.out.println(readTens(tens));
			} else {
				System.out.println(readTens(tens) + " " + readOnes(ones));
			}
		} else if (number >= 100 && number < 1000) {
			int hundreds = number / 100;
			int ten = (number - (hundreds * 100));
			int tens = ten / 10;
			int ones = ten % 10;
			if (number % 100 == 0) {
				System.out.println(readOnes(hundreds) + " hundred");
			} else {
				if (tens == 1) {
					System.out.println(readOnes(hundreds) + " hundred and " + readTenToNineteen(ten));
				} else if (tens == 0) {
					System.out.println(readOnes(hundreds) + " hundred and " + readOnes(ones));
				} else if (ones == 0) {
					System.out.println(readOnes(hundreds) + " hundred and " + readTens(tens));
				} else {
					System.out.println(readOnes(hundreds) + " hundred and " + readTens(tens) + " " + readOnes(ones));
				}
			}
		} else {
			System.out.println("Out of ability");
		}
	}

	public static void main(String[] args) {
		input();
		convertToWord();
	}
}
