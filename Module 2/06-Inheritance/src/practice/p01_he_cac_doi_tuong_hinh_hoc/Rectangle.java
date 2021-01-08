package practice.p01_he_cac_doi_tuong_hinh_hoc;

public class Rectangle extends Shape {

	protected double width;
	protected double height;

	public Rectangle() {
		width = 1.0;
		height = 1.0;
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(String color, boolean filled, double width, double height) {
		super(color, filled);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return this.width * this.height;
	}

	public double getPerimeter() {
		return 2 * (this.width + this.height);
	}

	public String toString() {
		return "A Rectangle with width = " + this.width + " and length = " + this.height + ", which is a subclass of "
				+ super.toString();
	}

}
