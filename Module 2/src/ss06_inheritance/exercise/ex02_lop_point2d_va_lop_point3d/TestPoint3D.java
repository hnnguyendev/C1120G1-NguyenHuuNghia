package ss06_inheritance.exercise.ex02_lop_point2d_va_lop_point3d;

public class TestPoint3D {

	public static void main(String[] args) {
		Point2D point2d = new Point2D(2, 3);

		Point3D point3d = new Point3D(7);
		point3d.setX(point2d.getX());
		point3d.setY(point2d.getY());
		System.out.println(point3d);

	}

}
