package practice.p01_he_cac_doi_tuong_hinh_hoc;

public class Square extends Rectangle {

	public Square() {
		this.width = 1.0;
		this.height = 1.0;
	}

	public Square(double side) {
		super(side, side);
	}

	public Square(double side, String color, boolean filled) {
		super(color, filled, side, side);
	}

	public double getSide() {
		return this.getWidth();
	}

	public void setSide(double side) {
		this.setWidth(side);
		this.setHeight(side);
	}

	@Override
	public String toString() {
		return "A Square with side = " + getSide() + ", which is a subclass of " + super.toString();
	}

}
