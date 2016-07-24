import java.awt.Color;
import java.util.Random;

public class background {
	 static int numbLanes = 6;
	 static int HEIGHT = 640;
 
	 static int WIDTH = 650;
	 static int RoadWidth = 80; 

	//construct background 
	public background() {
	}
	
	
	//draw background
	public static void drawlanes() {

		// draw lanes
		StdDraw.setPenColor(Color.BLACK);
		for (int n = 0; n < numbLanes; n++) {
			StdDraw.filledRectangle(0, 120 + n * RoadWidth, WIDTH + 100, 35);
		}
		
		//draw grass
		StdDraw.picture(200, -230, "grass.png");
		StdDraw.picture(500, -230, "grass.png");
		StdDraw.picture(200, HEIGHT + 230, "grass.png");
		StdDraw.picture(400, HEIGHT + 230, "grass.png");
		StdDraw.picture(650, HEIGHT + 230, "grass.png");
		
		//DRAW SIDEWALKS
		StdDraw.setPenColor(Color.gray);
		StdDraw.filledRectangle(WIDTH/2, 60, WIDTH, 20);
		StdDraw.filledRectangle(WIDTH/2, HEIGHT - 60, WIDTH, 20);
		
	}
	
	public int getNumberOfLanes() {
		return numbLanes; 
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public int getWidth() {
		return WIDTH;
	}

}
