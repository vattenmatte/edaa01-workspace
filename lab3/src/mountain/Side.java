package mountain;

import mountain.Point;

public class Side {
	public Point x;
	public Point y;
	public Point midPoint;

	public Side(Point x, Point y, Point midPoint) {
		this.x = x;
		this.y = y;
		this.midPoint = midPoint;
	}
}
