package exercise.ex03_lop_point_va_moveablepoint;

import java.util.Arrays;

public class Point {

	private float x;
	private float y;

	public Point() {
		x = 0f;
		y = 0f;
	}

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float[] getXY() {
		return new float[] { this.x, this.y };
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", getXY()=" + Arrays.toString(getXY()) + "]";
	}

}
