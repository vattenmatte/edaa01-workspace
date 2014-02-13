package mountain;

import fractal.*;

public class Mountain extends Fractal {
	private Point x;
	private Point y;
	private Point z;

	public Mountain(Point x, Point y, Point z) {
		super();
		this.x = x; 
		this.y = y;
		this.z = z;
	}

	public String getTitle() {
		return "Non-random Mountains";
	}

	public void draw(TurtleGraphics turtle) {		
		drawOut(turtle,x,y,z);
		drawTriangle(turtle, x, y, z, order); 
	}

	public void drawTriangle(TurtleGraphics turtle, Point x, Point y, Point z, int orderc) {
		if (orderc > 0) {			
			Point a = getNewMidPoint(x,y);
			Point b = getNewMidPoint(y,z);
			Point c = getNewMidPoint(x,z);
			drawOut(turtle,a,b,c);
			orderc--;
			combinatorialDrawTriangle(turtle,a,b,c,x,y,z,orderc);
		}
	}
	public void drawOut(TurtleGraphics turtle, Point a, Point b, Point c) {
		turtle.moveTo(a.getX(), a.getY());
		turtle.penDown();
		turtle.forwardTo(b.getX(), b.getY());
		turtle.forwardTo(c.getX(), c.getY());
		turtle.forwardTo(a.getX(), a.getY());
	}
	
	private Point getNewMidPoint(Point x, Point y) {
		Point midPoint = new Point((x.getX() + y.getX()) / 2, (x.getY() + y.getY()) / 2);
		return midPoint;
	}
	
	private void combinatorialDrawTriangle(TurtleGraphics turtle, Point a,
			Point b, Point c, Point x, Point y, Point z, int order) {
		drawTriangle(turtle, a, b, c, order);
		drawTriangle(turtle, x, a, c, order);
		drawTriangle(turtle, y, b, a, order);
		drawTriangle(turtle, z, c, b, order);
	}
}