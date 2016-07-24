import java.awt.event.KeyEvent;
import java.lang.*;

public class game_instance {
	static background map;
	static player p1;
	static car cars;
	static collision crash;
	
	static int WIDTH;
	static int HEIGHT;
	static boolean dead = false;

	//construct game instances so that new levels can be made
	public game_instance() {
	}
	//initialize games
	public static void start(int numbLanes, int numCars, int carSpeed) {
		
		map = new background();
		
		WIDTH = map.getWidth();
		HEIGHT = map.getHeight();
		
		p1 = new player(WIDTH/2, 60);
				
		cars = new car(numCars, numbLanes, carSpeed);
		
		crash = new collision(cars, p1);
		
		StdDraw.setCanvasSize(WIDTH,HEIGHT);
		StdDraw.setXscale(0,WIDTH);
		StdDraw.setYscale(0,HEIGHT);
		
		cars.init();


	}
	//load background,cars,player
	public static void play() {
		map.drawlanes();
		cars.runCar();
		p1.draw();	
		if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) { // Left arrow
			p1.move(p1.LEFT);
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) { // right arrow
			p1.move(p1.RIGHT);
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) { // up arrow
			p1.move(p1.UP);
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) { // down arrow
			p1.move(p1.DOWN);
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)){
			p1.move(p1.ESCAPE);
		} 
		
		if (crash.detectimpact(p1.getX(), p1.getY())) {
			dead = true;
		}
		

		StdDraw.show(100);
		StdDraw.clear();
	}
	public static boolean getDead() {
		return dead;
	}
	
	public static player getPlayer() {
		return p1;
	}
	
	public static background getBackground() {
		return map;
	}
	

}
