
public class GameWon {
	static boolean GameWon = false;
	static player p1;
	static background bg;
	static int HEIGHT;
	
	public GameWon(player p1, background bg) {
		this.p1 = p1;
		this.bg = bg;
		HEIGHT = this.bg.getHeight();
	}

	public static boolean victor() {
		if (p1.getY() >= HEIGHT - 30) {
			GameWon = true;
		}
		return GameWon;
	}
	
	public static boolean resetVictor() {
		GameWon = false;
		return GameWon;
	}
}
