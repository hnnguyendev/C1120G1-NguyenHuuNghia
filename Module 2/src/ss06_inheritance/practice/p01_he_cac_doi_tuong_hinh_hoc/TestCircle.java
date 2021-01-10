package ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc;

public class TestCircle {

	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println(circle);

		circle = new Circle(2.0);
		System.out.println(circle);

		circle = new Circle("yellow", false, 5.0);
		System.out.println(circle);

	}

}
