package ss05_access_modifier_static_method_static_property.practice.p02_static_method;

public class TestStudent {

	public static void main(String[] args) {
		Student.change();

		Student s1 = new Student(111, "Hoa");
		Student s2 = new Student(222, "Khanh");
		Student s3 = new Student(333, "Nam");

		s1.display();
		s2.display();
		s3.display();

	}

}
