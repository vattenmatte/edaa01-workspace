package mountain;

public class RandomUtilities {
	public static double randFuncO(double dev) {
		double t = dev * Math.sqrt(-2 * Math.log(Math.random()));
		if (Math.random() < 0.5) { //vad g�r detta? hmm..
			t = -t;
		}
		return t;
	}
	
	public static double randFuncT(double dev) {
		double t = dev * Math.sqrt(-2 * Math.log(Math.random()));
		return t;		
	}
}


