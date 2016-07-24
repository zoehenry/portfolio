import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class storyLine  {
	
	private static int numbStories = 4;
	
	//string arrays for each file
	private static String[] intro = new String[numbStories];
	private static String[] gEnd = new String[numbStories];
	private static String[] bEnd = new String[numbStories];
	private static String[] instruct = new String[1];
	private static int randomNumber;
	
	private static int random;
	
	//ArrayLists for each parsed file 
	private static ArrayList<String> instructParse = new ArrayList<String>();
	private static ArrayList<String> bEndParse = new ArrayList<String>();
	private static ArrayList<String> introParse = new ArrayList<String>();
	private static ArrayList<String> gEndParse = new ArrayList<String>();

//construct storyLine	
 public storyLine() {
 }
 
//reads instructions file 
//parses instructions wherever there is a period
//returns parsed instructions as a string ArrayList
 public ArrayList instructionsParsed() throws FileNotFoundException {
	 readFile("instructions", instruct);
	 for (int i = 0; i < instruct[0].toString().split("[.]").length; i++) {
		 instructParse.add((instruct[0].toString().split("[.]"))[i]);
	 }
	 return instructParse;
 }
 
//reads introductions file 
//parses introductions wherever there is a period
//chooses random story from a random index of instructions string array 
//returns parsed random introduction as a string ArrayList
 public ArrayList introductionParsed() throws FileNotFoundException {
	 readFile("introductions", intro);
	 randomNumber = random();
	 for (int i = 0; i< intro[randomNumber].toString().split("[.]").length; i++) {
		 introParse.add((intro[randomNumber].toString().split("[.]"))[i]);
	 }
	 return introParse;
 }

 //see introductions method comments
 public ArrayList goodEndingParsed() throws FileNotFoundException {
	  readFile("good_endings", gEnd);
	  randomNumber = random();
	  for (int i = 0; i < gEnd[randomNumber].toString().split("[.]").length; i++) {
		  gEndParse.add((gEnd[randomNumber].toString().split("[.]"))[i]);	 
	  }

	 return gEndParse;
 }

 //see introductions method comments
 public ArrayList badEndingParsed() throws FileNotFoundException {
	 readFile("bad_endings", bEnd);
	 randomNumber = random();
	 for (int i = 0; i < bEnd[randomNumber].toString().split("[.]").length; i++) {
		 bEndParse.add((bEnd[randomNumber].toString().split("[.]"))[i]);	 
	 }

	 return bEndParse;
 }

//reads text files, stores as string array
 public static void readFile(String file_name, String[] array) throws FileNotFoundException{
  
	 int story = 0;
  
	 File file = new File(file_name);
	 Scanner scan = new Scanner(file);
  
	 while(scan.hasNextLine()) {
		 array[story] = scan.nextLine();
		 story++;
	 }
 
 }

 //produces a random number
 public static int random() {
	 random = (int)(Math.random() * numbStories);
	 return random;
 }
 
 
}
