
public class Club {

	protected static int[][] clubs = { {230,30}, {215, 20}, {180, 20}, {170, 17},
			{155,15}, {145, 15}, {135, 15}, {125, 15}, {110, 10}, {50,10}};
			//[mean yrds][standard deviation]
	protected int[] clubType;
	protected int userChoice;
	
	public Club(int userChoice){
		this.clubType = clubType;
		this.userChoice = userChoice;
	}
	
	public void setClub(int userChoice){
		int[] clubType = new int[2];
		clubType[0] = clubs[userChoice][0];
		clubType[1] = clubs[userChoice][1];
		this.clubType = clubType;//[mean yrds, std deviation]
	}
	public int[] getClub(){
		return clubType;
	}
	public static void main(String[] args) {
		System.out.println(clubs[1][1]);
	}
}
