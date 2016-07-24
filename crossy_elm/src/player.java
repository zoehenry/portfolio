public class player {

	private double x;
	private double y;
	private double sizeStep;

	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	public static final int ESCAPE = 4;
	public static final int REPLAY = 5;
	
	background huh = new background();

	// construct student at location (x,y)
	public player(double x, double y) {
		this.x = x;
		this.y = y;
		sizeStep = 80;
	}
	public void setNewPos(double x, double y){
		this.x = x;
		this.y= y;
	}
	public void draw() {
		StdDraw.picture(x, y, "Man.png", 50, 50);
	}

	public double getX() { return x; }

	public double getY() { return y; }


	// move student up/down/left/right
	public void move(int direction) {
		switch (direction) {
		case LEFT:  
			if (x > 0) x -= sizeStep; 
			if (x == 0) x -= 0;
			break;
		case RIGHT: 
			if (x < huh.getWidth()) x += sizeStep; 
			if (x == huh.getWidth()) x += 0;
			break;
		case UP:    
			if (y < huh.getHeight()) y += sizeStep; 
			if (y == huh.getHeight()) y += 0;
			break;
		case DOWN:  
			if (y > 0) y -= sizeStep; 
			if (y == 0) y -= 0;
			break;
		case ESCAPE:
			System.exit(0);
			break;
		case REPLAY:
			y = 60;
			x = huh.getWidth()/2;
		}

	}

} 

