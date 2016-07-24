
public class LevelWon {
	static boolean LevelWon = false;
	static player p1;
	static background bg;
	static int HEIGHT;
	
	//construct detector for winning levels
	public LevelWon(player p1, background bg) {
		this.p1 = p1;
		this.bg = bg;
		HEIGHT = this.bg.getHeight();
	}

	//check if victor has crossed the street
	public static boolean victor() {
		if (p1.getY() >= HEIGHT - 30) {
			LevelWon = true;
		}
		return LevelWon;
	}
	
	public static boolean resetVictor() {
		LevelWon = false;
		return LevelWon;
	}
}



