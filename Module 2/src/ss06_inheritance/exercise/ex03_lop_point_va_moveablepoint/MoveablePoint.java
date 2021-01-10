package ss06_inheritance.exercise.ex03_lop_point_va_moveablepoint;

import java.util.Arrays;

public class MoveablePoint extends Point {

	private float xSpeed;
	private float ySpeed;

	public MoveablePoint() {
		xSpeed = 0f;
		ySpeed = 0f;
	}

	public MoveablePoint(float xSpeed, float ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
		super(x, y);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public float getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}

	public float getySpeed() {
		return ySpeed;
	}

	public void setySpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}

	public void setSpeed(float xSpeed, float ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public float[] getSpeed() {
		return new float[] { this.xSpeed, this.ySpeed };
	}

	@Override
	public String toString() {
		return "MoveablePoint [xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + ", getSpeed()=" + Arrays.toString(getSpeed())
				+ ", getX()=" + getX() + ", getY()=" + getY() + ", getXY()=" + Arrays.toString(getXY()) + "]";
	}

	public MoveablePoint move() {
		setX(getX() + this.xSpeed);
		setY(getY() + this.ySpeed);
		return this;
	}

}
