package ss06_inheritance.practice.p01_he_cac_doi_tuong_hinh_hoc;

public class TestShape {

	public static void main(String[] args) {
		Shape shape = new Shape();
		System.out.println(shape);

		shape = new Shape("red", false);
		System.out.println(shape);

	}

}
