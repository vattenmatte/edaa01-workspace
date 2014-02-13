package mountain;

import fractal.*;

public class RightMountain extends Fractal {
	private Point x;
	private Point y;
	private Point z;
	private Double devi;
	
	public RightMountain(Point x, Point y, Point z, double dev) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.devi = dev;
	}

	public String getTitle() {
		return "Mountains";
	}

	public void draw(TurtleGraphics turtle) {
		drawTriangle(turtle, x, y, z, order, devi);
	}

	public void drawTriangle(TurtleGraphics turtle, Point x, Point y, Point z,
			int orderc, double deviation) {
		if (orderc == 0) {
			drawOut(turtle, x, y, z);
		} else {
			double random = RandomUtilities.randFuncO(deviation);
			Point a = getNewMidPoint(x, y, random);
			Point b = getNewMidPoint(y, z, random);
			Point c = getNewMidPoint(x, z, random);
			deviation = deviation / 2;
			combinatorialDrawTriangle(turtle, a, b, c, x, y, z, orderc-1,
					deviation);
		}
	}

	public void drawOut(TurtleGraphics turtle, Point a, Point b, Point c) {
		turtle.moveTo(a.getX(), a.getY());
		turtle.penDown();
		turtle.forwardTo(b.getX(), b.getY());
		turtle.forwardTo(c.getX(), c.getY());
		turtle.forwardTo(a.getX(), a.getY());
	}

	private Point getNewMidPoint(Point x, Point y, double randomNumber) {
		return new Point((x.getX() + y.getX()) / 2, (randomNumber + (x.getY() + y.getY()) / 2));
	}

	private void combinatorialDrawTriangle(TurtleGraphics turtle, Point a,
			Point b, Point c, Point x, Point y, Point z, int order,
			double deviation) {
		drawTriangle(turtle, x, a, c, order, deviation);
		drawTriangle(turtle, y, b, a, order, deviation);
		drawTriangle(turtle, z, c, b, order, deviation);
		drawTriangle(turtle, a, b, c, order, deviation);

	}
}
