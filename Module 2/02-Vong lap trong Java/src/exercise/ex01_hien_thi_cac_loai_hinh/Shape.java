package exercise.ex01_hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class Shape {

	static int choice;
	static int subChoice;

	static void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("1. Print the rectangle");
		System.out.println("2. Print the square triangle ");
		System.out.println("3. Print isosceles triangle");
		System.out.println("0. Exit");
		System.out.println("Enter your choice:");
		choice = scanner.nextInt();
	}

	static void inputSub() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose the corner");
		System.out.println("1. top-left");
		System.out.println("2. top-right");
		System.out.println("3. bottom-left");
		System.out.println("4. bottom-right");
		System.out.println("Enter angel:");
		subChoice = scanner.nextInt();
	}

	static void printRectangle() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void printSquareTriangleTL() {
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void printSquareTriangleTR() {
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("  ");
			}
			for (int k = 5; k > i; k--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void printSquareTriangleBL() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void printSquareTriangleBR() {
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print("  ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void PrintIsoscelesTriangle() {
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print("  ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("* ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void chooseShape() {
		switch (choice) {
		case 1:
			printRectangle();
			break;
		case 2:
			inputSub();
			switch (subChoice) {
			case 1:
				printSquareTriangleTL();
				break;
			case 2:
				printSquareTriangleTR();
				break;
			case 3:
				printSquareTriangleBL();
				break;
			case 4:
				printSquareTriangleBR();
				break;
			default:
				System.out.println("No choice!");
				break;
			}
			break;
		case 3:
			PrintIsoscelesTriangle();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("No choice!");
			break;
		}
	}

	public static void main(String[] args) {
		while (true) {
			input();
			chooseShape();
		}

	}

}
