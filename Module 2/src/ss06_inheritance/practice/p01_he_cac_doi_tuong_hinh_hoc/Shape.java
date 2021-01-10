package ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc;

public class Shape {

	protected String color;
	private boolean filled;

	public Shape() {
		color = "green";
		filled = true;
	}

	public Shape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public String toString() {
		return "A Shape with color of " + this.color + " and " + (this.filled ? "filled" : "not filled");
	}

}
