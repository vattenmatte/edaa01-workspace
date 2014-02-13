package fractal;

import koch.Koch;
import mountain.*;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[7];
		Point x = new Point(50, 550);
		Point y = new Point(550, 550);
		Point z = new Point(275, 100);
		Point a = new Point(20, 600);
		Point b = new Point(580, 600);
		Point c = new Point(270, 470);
		double devBouldery = 0.4;
		double devLandscape = 0.3;
		double devMidP = 50;
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(x, y, z);
		fractals[2] = new RightMountain(x, y, z, devMidP);
		fractals[3] = new RandomMountain(x, y, z, devBouldery, 2);
		fractals[4] = new RandomMountain(a, b, c, devLandscape, 3);
		fractals[5] = new RandomMountainSide(x, y, z, devMidP);
		fractals[6] = new D6b(x, y, z, devMidP);
		new FractalView(fractals, "Mattias samlade fraktaler");
	}
}
