package exercise.ex02_lop_point2d_va_lop_point3d;

import java.util.Arrays;

public class Point2D {

	protected float x;
	protected float y;

	public Point2D() {
		x = 0f;
		y = 0f;
	}

	public Point2D(float x, float y) {
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
		return "Point2D [x=" + x + ", y=" + y + ", getXY()=" + Arrays.toString(getXY()) + "]";
	}

}
