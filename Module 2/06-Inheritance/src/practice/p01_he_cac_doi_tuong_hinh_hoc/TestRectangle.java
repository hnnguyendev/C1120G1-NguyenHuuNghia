package practice.p01_he_cac_doi_tuong_hinh_hoc;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		System.out.println(rectangle);

		rectangle = new Rectangle(20d, 10d);
		System.out.println(rectangle);

		rectangle = new Rectangle("pink", true, 50d, 20d);
		System.out.println(rectangle);
	}

}
