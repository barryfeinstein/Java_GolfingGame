
public class Course {
	protected int userChoice;
	public Object[][] course; //array containing yards, par, and additional info for each hole
	//[yards/hole# - 1] [ par # ]
	public String courseName;
	public Course(int userChoice){
		this.userChoice = userChoice;
		this.course = course;
		
		if(userChoice == 1)
			courseName = "Genesee Valley Park";
		else if(userChoice == 2)
			courseName = "The Old Course at St. Andrews";
		//helps print course selection
			
	}
	
	public Object[][] setCourse(int userChoice){ //allows user's choice to select course type
		if(userChoice == 1){
			course = new Object[][]{{530,5}, {305,4}, {331,4}, {201,3},{500,5}, {226,3}, {409,4}, {410,229}, {433,4}, {363,4}, {174, 3}, {545, 5}, {419, 4}, {512,5}, {410,4}, {320,4}, {170,3}};	
			//Genesee Valley Park -- create 2D array to make data accessible elsewhere
			return course;
		}	
		if(userChoice == 2){
			course = new Object[][] {{376, 4}, {453, 4}, {397, 4}, {480, 4}, { 568, 5}, { 412, 4}, {371, 4}, {175, 3}, {352, 4}, {386, 4}, {174,3}, {348, 4}, {465, 4}, {618, 5}, {455, 4}, {423, 4}, {495, 4}, {357,4}};
			//The Old Course
			return course;
		}	
		else{
			course = new Object[][] { {0, 0} };
			return course;
			//return empty course
		}
		//generates course arrays based on user choice
				
	}
	public Object[][] getCourse(){
		return course;
	}
	//return course array from user selection
	
	public void setChoice(int userChoice){
		this.userChoice = userChoice;
	}
	public int getChoice(){
		return userChoice;
	}
	//allows user input to be called
	
}

