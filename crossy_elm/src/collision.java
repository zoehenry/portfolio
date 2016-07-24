public class collision {
	
	static car vehicles;
	static player p1;
	static boolean crash = false;
	
	private static int numCars;

	final static int carwidth = 100;
	final static int carheight = 50;
	final static int carregionx = carwidth/2 + 15;
	final static int carregiony = carheight/2 + 15;

	//constructs collision reader
	public collision(car cars, player p1) {
		this.vehicles = cars;
		this.p1 = p1;
		numCars = cars.getNumCars();
	}
	//checks for collision 
	public static boolean detectimpact(double x, double y){ //needs input from student class
		for (int n = 0; n < numCars; n++){
			if ((vehicles.getx()[n] + carregionx >= x && vehicles.getx()[n] - carregionx <= x )
					&& (vehicles.gety()[n] + carregiony >= y && vehicles.gety()[n] - carregiony <= y))
			{
				crash = true;
			}
		}
		return crash;
				
	}
}
