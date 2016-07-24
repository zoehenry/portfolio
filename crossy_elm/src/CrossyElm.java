import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CrossyElm {

	static boolean LevelWon = false; 
	static game_instance level1;
	static game_instance level2;
	static game_instance level3;
	static game_instance level4;
	static LevelWon winner;
	static storyLine stories = new storyLine();
	static ArrayList<String> Parsings;
	
	static game_instance[] levels = {level1, level2, level3, level4};
	
	private static int lanes = 6;
	private static int cars = 6;
	private static int speed = 200;
	private static int level = 0;
	
	private static String music = "music.wav";
	private static String loseMusic = "loseMusic.wav";
	private static String winMusic = "winMusic.wav";
	
	static background map;
	static int WIDTH = 650;
	static int HEIGHT = 640;
	

	public static void main(String args[]) throws FileNotFoundException {
		Audio.playSong(music);
		playCrossyElm();
	}
	
	public static void playCrossyElm() throws FileNotFoundException {

		
		createLevel(lanes, cars, speed, level);
		introductionScreen();
		instructionsScreen();

		//game loops for four levels 
		Restart:
			while (true) {
				playLevel(level);
				if (winner.victor()) {
					playLevel(level);
					if (cars <= 12) {
						cars += 2;
					}
					speed += 50;
					if (level < 4) {
						level++;
					}
					
					//game won when four levels beaten
					if(level == 4) {
						Audio.playSong(music);
						level = 0;
						lanes = 6;
						cars = 6;
						speed = 200;
						winScreen();
						
					}

					newLevel(lanes, cars, speed, level);
					
					continue Restart;
				}
				if (game_instance.getDead()) {
					StdDraw.clear();

					break;
				}

			}
		deathScreen();
	}
	
	//reset player
	public static void newLevel(int lanes, int cars, int speed, int level) {
		levels[level] = new game_instance();
		createLevel(lanes, cars, speed, level);
		levels[level].getPlayer().setNewPos(levels[level].getBackground().getWidth()/2, 60);
		winner.resetVictor();
		
	}
	//makes new level with incremented cars,speed
	public static void createLevel(int lanes, int cars, int speed, int level) {
		levels[level].start(lanes, cars, speed);
		winner = new LevelWon(levels[level].p1,levels[level].getBackground());	
	}
	//plays newly created level
	public static void playLevel(int level) {
		levels[level].play();
	}
	
	//end sequence- lost game
	public static void deathScreen() throws FileNotFoundException {
		Audio.playSong(loseMusic);
		Parsings = stories.badEndingParsed();
		displayParsings(Parsings.size());
		System.exit(0);

	}
	//end sequence- winning game
	public static void winScreen() throws FileNotFoundException{
		Audio.playSong(winMusic);
		Parsings = stories.goodEndingParsed();
		displayParsings(Parsings.size());
		System.exit(0);
	}
	//introduction storyline
	public static void introductionScreen() throws FileNotFoundException{
		Font font = new Font("Official Tyrant", Font.BOLD, 60);
		StdDraw.setFont(font);
		map.drawlanes();
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(WIDTH/2, HEIGHT/3-20, "C R O S S Y  E L M");
		StdDraw.text(WIDTH/2, HEIGHT - HEIGHT/3, "C R O S S Y  E L M");
		StdDraw.show(3000);
		Parsings = stories.introductionParsed();
		displayParsings(Parsings.size());
	}
	//instructions 
	public static void instructionsScreen() throws FileNotFoundException{
		Parsings = stories.instructionsParsed();
		displayParsings(Parsings.size());
	}
	
	//display text/story lines 
	public static void displayParsings(int size) throws FileNotFoundException {
		StdDraw.setPenColor(StdDraw.BLACK);
		Font font = new Font("Official Tyrant", Font.BOLD, 16);
		StdDraw.setFont(font);
		for (int i = 0; i <size; i++) {
			map.drawlanes();
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.filledRectangle(WIDTH/2, HEIGHT/2, WIDTH/2, HEIGHT/6);
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.text(WIDTH/2, HEIGHT/2, Parsings.get(i).toString());
			StdDraw.show(2000);
			StdDraw.clear();

		}
	}

}



