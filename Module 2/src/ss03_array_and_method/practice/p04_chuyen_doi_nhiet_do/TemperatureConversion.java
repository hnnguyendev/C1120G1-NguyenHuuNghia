package ss03_array_and_method.practice.p04_chuyen_doi_nhiet_do;

import java.util.Scanner;

public class TemperatureConversion {

	public static int choice;
	public static int fahrenheit;
	public static int celsius;

	public static void input() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Menu\n" + "1. Fahrenheit to Celsius\n" + "2. Celsius to Fahrenheit\n" + "0. Exit\n"
					+ "Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Fahrenheit:");
				fahrenheit = scanner.nextInt();
				System.out.println(fahrenheit + " 0F = " + fahrenheitToCelsius(fahrenheit) + " 0C");
				break;
			case 2:
				System.out.println("Enter Celsius:");
				celsius = scanner.nextInt();
				System.out.println(celsius + " 0C = " + celsiusToFahrenheit(celsius) + " 0F");
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("No choice!");
				break;
			}
		} while (true);
	}

	public static double celsiusToFahrenheit(int celsius) {
		return (9.0 / 5) * celsius + 32;
	}

	public static double fahrenheitToCelsius(int fahrenheit) {
		return (5.0 / 9) * (fahrenheit - 32);
	}

	public static void main(String[] args) {
		input();

	}

}
