package ss06_inheritance.exercise.ex03_lop_point_va_moveablepoint;

public class TestMoveablePoint {

	public static void main(String[] args) {
		Point point = new Point(3, 5);
		System.out.println(point);

		MoveablePoint moveablePoint = new MoveablePoint(4, 4);
		System.out.println(moveablePoint);

		moveablePoint.setX(point.getX());
		moveablePoint.setY(point.getY());

		moveablePoint.move();
		
		System.out.println(moveablePoint);

	}

}
