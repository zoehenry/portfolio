import java.util.ArrayList;
import java.util.Random;

public class car {

	static String blue = "bluecar.png";
	static String orange = "orangecar.png";
	static String[] colors = {blue, orange};
	
	private static double dt = 0.1;
	private static double RoadWidth = 80.0;

	
	private static int numCars;
	private static int v;
	private static int numOfLanes;
	
	static ArrayList<Double> xpos = new ArrayList<Double>();
	static ArrayList<Double> ypos = new ArrayList<Double>();
	static ArrayList<Double> y = new ArrayList<Double>();
	static ArrayList<String> carColor = new ArrayList<String>();
	
	static Random random = new Random();
	
	//construct car
	public car(int numbCars, int numbLanes, int carSpeed) {
		numCars = numbCars;
		v = carSpeed;
		numOfLanes = numbLanes;
		
	}
	//initialize cars' position, choose random lane to run on 
	public static void init() {
		double x = 0;
		for (int l = 0; l < numOfLanes; l++) {
			y.add(120.0 + (RoadWidth * l));
		}
		
		for (int i = 0, dx = 0; i < numCars; i++, dx+=125) {
			
			carColor.add(colors[random.nextInt(colors.length)]);
			ypos.add(y.get(random.nextInt(numOfLanes)));
			xpos.add(x - dx);
		}

	}

	//update position, draw cars 
	public static void runCar() {
		
		//updating x
		for(int n = 0; n < numCars; n++){
			if (xpos.get(n) - RoadWidth > background.WIDTH) {
				xpos.set(n, -RoadWidth);
				ypos.set(n, y.get(random.nextInt(numOfLanes)));

			}
			else
				xpos.set(n, xpos.get(n) + v*dt);


		}
		for (int n = 0; n < numCars; n++) {
			StdDraw.picture(xpos.get(n), ypos.get(n), carColor.get(n));
		}

	}
	
	public double[] getx (){
		double xpositioncar[] = new double[numCars];
		for (int n = 0; n < numCars; n++){
			xpositioncar[n] = xpos.get(n);
		}

		return xpositioncar;
	}

	public double[] gety (){
		double ypositioncar[] = new double[numCars];
		for (int n = 0; n < numCars; n++){
			ypositioncar[n] = ypos.get(n);
		}

		return ypositioncar;
	}
	
	public static int getNumCars() {
		return numCars;
	}
	

}
