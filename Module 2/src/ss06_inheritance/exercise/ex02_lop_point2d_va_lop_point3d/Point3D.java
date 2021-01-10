package ss06_inheritance.exercise.ex02_lop_point2d_va_lop_point3d;

import java.util.Arrays;

public class Point3D extends Point2D {

	private float z;

	public Point3D() {
		z = 0f;
	}

	public Point3D(float z) {
		this.z = z;
	}

	public Point3D(float x, float y, float z) {
		super(x, y);
		this.z = z;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public void setXYZ(float x, float y, float z) {
		super.x = x;
		super.y = y;
		this.z = z;
	}

	public float[] getXYZ() {
		return new float[] { super.getX(), super.getY(), this.z };
	}

	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + ", getXYZ()=" + Arrays.toString(getXYZ()) + "]";
	}

}
