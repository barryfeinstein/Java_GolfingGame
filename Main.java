import java.util.Random;
import java.util.Scanner;

public class main {
	public static int stroke = 1;
	public static int power;
	public static int par;
	public static int totalpar;
	public static Object[][] greenPutt = { {1,1}, {2,1}, {4,2}, {8,2}, {12,3}, {16,3}, {20,4}, {25,4}, {30,5}, {40,5}}; //Gaussian Dist. for shots in the green
	public static int hole = 0; //start on the first hole, which is 0 in an array
	static int userChoice;
	
	static Random random = new Random();
	static Scanner scan = new Scanner(System.in);
	
	public static int nextDistance(int mean, int stddev, int power) {
		double mean_adj = mean * power / 10.0;
		double stddev_adj = stddev * power / 10.0;
		double distance = Math.abs(random.nextGaussian() * stddev_adj + mean_adj);
		return (int) distance;
		}
	
	//accounts for course selection
	public static Object[][] courseSelect(){
		System.out.println("Welcome to Virtual Golf.\nPlease select a golf course: ");
		System.out.println("1. Genessee Valley Park\nor\n2. The Old Course");//course options
		int userChoice = scan.nextInt();
		Object[][] courseArray;
		Course course = new Course(userChoice); //call Course class
		courseArray = course.setCourse(userChoice); //[yards/hole # - 1] [ par # ]
		System.out.println("\nYou are playing at " + course.courseName);
		return courseArray;	
	}
	
	//accounts for anything happen in and outside of the green
	public static int play(int distance){
		
		Object[][] courseArray = courseSelect();//choose a course, bring in it's data array
		int currentDistance = (int) courseArray[hole][0]; //start current distance variable
		par = (int) courseArray[hole][1];
		//Call golf course based on user choice, in array format
		
		while(true){//keeps loop working if ball is hit back out of green
							
			while(currentDistance > distance){
				if(currentDistance <= 1){ //if ball gets to hole
					hole++;
					currentDistance = (int) courseArray[hole][0];
					totalpar += par;
					par = (int) courseArray[hole][1];
					stroke = 0;
					hole();
					//reset for next hole when person scores
				}
				System.out.println("\nStroke: " + stroke + " Current Distance: " + currentDistance + " Par: " + par + " Hole: " + hole);

				int[] club = new int[2];
				//Create user club
				
				System.out.println("Pick a golf club, 1-10 (Driver, 3-wood, 4- to 9-iron, wedge): ");
				int userChoice = scan.nextInt();
				
				Club clubChoice = new Club(userChoice - 1);//accounts for arrays starting at 0
				clubChoice.setClub(userChoice - 1);
				club = clubChoice.getClub(); //starting from 0, [mean yrds, standard deviation]
				
				
				System.out.println("How much power would you like to hit the ball with (1-10)?");
				power = scan.nextInt();
				
				int hitDist = nextDistance(club[0], club[1], power);
				currentDistance -= hitDist;
				currentDistance = Math.abs(currentDistance); //negative numbers aren't relevant to gameplay
				
				System.out.println("Your ball went " + hitDist + " feet, leaving you " + currentDistance + " feet away from the hole.");
				//uses nextDistance method, subtract from current distance to print remaining
			
				stroke++;
				par--;
				
			}
			
			while(currentDistance <= distance){
				if(currentDistance <= 1){ //if ball gets to hole
					hole++;
					currentDistance = (int) courseArray[hole][0];
					totalpar += par;
					par = (int) courseArray[hole][1];
					stroke = 0;
					hole();
				}
				System.out.println("You're in the green!\nStroke: " + stroke + " Distance: " + currentDistance + " Par: " + par + " Hole: " + hole);

				System.out.println("How much power would you like to hit the ball with (1-10)?");
				power = scan.nextInt() - 1;//account for greenPutt being an array, -1
				
				int hitDist = nextDistance((int) greenPutt[power][0], (int) greenPutt[power][1], power); // new distance based on rules of the green
				currentDistance -= hitDist;
				currentDistance = Math.abs(currentDistance); //negative numbers aren't relevant to gameplay
				
				System.out.println("Your ball went " + hitDist + " feet, leaving you " + currentDistance + " feet away from the hole.");
				//uses nextDistance method, subtract from current distance to print remaining
							
				stroke++;
				par--;
			}
		}		
	}
	
	//accounts for getting into the hole, as well as game progression
	public static void hole(){
		if(hole == 17){
			System.out.println("You've finished the course with a total par of " + totalpar + ", would you like to try a different one?");
			courseSelect();
		}
		System.out.println("You sunk it - on to the next round!");
	}
	
	public static void main(String[] args) {
		play(20); // dictates that the green is at a distance of 20
				
	}
}
