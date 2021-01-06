package exercise.ex03_xay_dung_lop_fan;

public class Fan {

	private final int SLOW = 1;
	private final int MEDIUM = 2;
	private final int FAST = 3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String color = "blue";

	public Fan() {
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSLOW() {
		return SLOW;
	}

	public int getMEDIUM() {
		return MEDIUM;
	}

	public int getFAST() {
		return FAST;
	}

	@Override
	public String toString() {
		if (on) {
			return "Fan [speed=" + speed + ", radius=" + radius + ", color=" + color + "]" + " fan is On";
		}
		return "Fan [radius=" + radius + ", color=" + color + "]" + " fan is Off";
	}

	public static void main(String[] args) {
		Fan fan1 = new Fan();
		fan1.setSpeed(fan1.getFAST());
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		System.out.println(fan1.toString());

		Fan fan2 = new Fan();
		fan2.setSpeed(fan2.getMEDIUM());
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setOn(false);
		System.out.println(fan2.toString());

	}

}
