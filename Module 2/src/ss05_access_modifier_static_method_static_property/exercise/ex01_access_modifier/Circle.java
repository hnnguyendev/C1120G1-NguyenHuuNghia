package ss05_access_modifier_static_method_static_property.exercise.ex01_access_modifier;

public class Circle {

	private double radius;
	private String color;

	public Circle() {
		radius = 1.0;
		color = "red";
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

}
