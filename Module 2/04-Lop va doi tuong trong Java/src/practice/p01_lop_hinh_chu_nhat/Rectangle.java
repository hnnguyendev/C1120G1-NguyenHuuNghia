package practice.p01_lop_hinh_chu_nhat;

import java.util.Scanner;

public class Rectangle {

	private double width;
	private double height;

	public Rectangle() {

	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getArea() {
		return this.width * this.height;
	}

	public double getPerimeter() {
		return (this.width + this.height) * 2;
	}

	public String display() {
		return "Rectangle{" + "width=" + this.width + ", height=" + this.height + "}";
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the width:");
		double width = scanner.nextDouble();
		System.out.println("Enter the height:");
		double height = scanner.nextDouble();

		Rectangle rectangle = new Rectangle(width, height);
		System.out.println("Your Rectangle: " + rectangle.toString());
		System.out.println("Perimeter of Rectangle: " + rectangle.getPerimeter());
		System.out.println("Area of Rectangle: " + rectangle.getArea());

	}

}
