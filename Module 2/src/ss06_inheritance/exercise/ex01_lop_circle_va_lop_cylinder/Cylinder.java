package ss06_inheritance.exercise.ex01_lop_circle_va_lop_cylinder;

public class Cylinder extends Circle {

	private double height;

	public Cylinder() {
	}

	public Cylinder(double height) {
		this.height = height;
	}

	public Cylinder(double radius, String color, double height) {
		super(radius, color);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return super.getArea() * 2 + super.getPerimeter() * this.height;
	}

	public double getVolumn() {
		return super.getArea() * this.height;
	}

	@Override
	public String toString() {
		return "Cylinder [height=" + height + ", color=" + color + ", getArea()=" + getArea() + ", getVolumn()="
				+ getVolumn() + "]";
	}

}
