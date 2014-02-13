package mountain;

import fractal.*;

public class D6b extends Fractal {
	private Point x;
	private Point y;
	private Point z;
	private Double devi;
	private int title;
	private Point a,b,c;
	
	//Fundera på ifall denna fungerar. Sätter dev till noll för a,b,c kombon.

	public D6b(Point x, Point y, Point z, double dev) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.devi = dev;
	}

	public String getTitle() {
		return "D6b";
	}

	public void draw(TurtleGraphics turtle) {
		drawTriangle(turtle, x, y, z, order, devi);
	}

	public void drawTriangle(TurtleGraphics turtle, Point x, Point y, Point z,
			int orderc, double deviation) {
		if (orderc == 0) {
			drawOut(turtle, x, y, z);
		} else {
			double randomOne = RandomUtilities.randFuncO(deviation);
			double randomTwo = RandomUtilities.randFuncO(deviation);
			double randomThree = RandomUtilities.randFuncO(deviation);
			a = getNewMidPoint(x, y, randomOne);
			b = getNewMidPoint(y, z, randomTwo);
			c = getNewMidPoint(x, z, randomThree);
			if ((orderc--) > 0) {
				combinatorialDrawOut(turtle, a, b, c, x, y, z);
				if (title != 1) {
					deviation = deviation / 2;
				}
				combinatorialDrawTriangle(turtle, a, b, c, x, y, z, orderc,
						deviation);
			}
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
		Point midPoint = new Point((x.getX() + y.getX()) / 2, randomNumber
				* (x.getY() + y.getY()) / 2 + (x.getY() + y.getY()) / 2);
		return midPoint;
	}

	private void combinatorialDrawTriangle(TurtleGraphics turtle, Point a,
			Point b, Point c, Point x, Point y, Point z, int order,
			double deviation) {
		drawTriangle(turtle, x, a, c, order, deviation);
		drawTriangle(turtle, y, b, a, order, deviation);
		drawTriangle(turtle, z, c, b, order, deviation);
		drawTriangle(turtle, a, b, c, order, 0);
	}

	private void combinatorialDrawOut(TurtleGraphics turtle, Point a, Point b,
			Point c, Point x, Point y, Point z) {
		drawOut(turtle, x, a, c);
		drawOut(turtle, y, b, a);
		drawOut(turtle, z, c, b);
		drawOut(turtle, a, b, c);
	}
}
