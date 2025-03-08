package scorecardOOPS;

import java.util.Scanner;

public class Scorecard {
	
	Scanner s = new Scanner(System.in);
	private Team team1; 
	private Team team2; 
	private int totalOvers;
	 
	
	public Scorecard (){
		team1 = new Team(); 
		team2 = new Team(); 
		totalOvers=0;
	}
	
	public void run() {
		
		welcome(); 
		
		takeInputs(); 
		
		printInstructions(); 
		
		
		System.out.println("FIRST INNINGS\n");
		team1.innings(Integer.MAX_VALUE, totalOvers); 
		
		System.out.println("\n\nFinal Score: "+team1.runs+"-"+team1.wickets+"\n\n");
		
		int target = team1.runs+1; 
		
		System.out.println("SECOND INNINGS\n"); 
		team2.innings(target, totalOvers);
		
		results(target); 
		
		
		System.out.println("\nMATCH SUMMARY\n");
		team1.stats(); 
		team2.stats(); 
		
		
	}

	

	private void results(int target) {
		
		if(team2.runs==team1.runs) {
			System.out.println("\nMATCH TIED\n");
			return; 
		}
		
		if(team2.wickets==10) {
			System.out.println("\n"+team1.teamName+" WINS BY "+(target-team2.runs)+"\n");
			return; 
		}
		
		if(team2.runs>=target) {
			System.out.println("\n"+team2.teamName+" WINS BY "+(10-team2.wickets)+"\n");
			return; 
		}
		
		
		
		
	}

	private void printInstructions() {
		System.out.println("\n\nInstructions:\nPlease enter a value from 1 to 6 for each ball of the over");
		System.out.println("Enter 'o' or 'O' for wicket.");
		System.out.println("Enter 'w' or 'W' for wide");
	}

	private void takeInputs() {
		
		System.out.println("\nPlease enter the teams participating\n");
		
		System.out.print("Batting First: ");
		team1.teamName = s.next(); 
		
		System.out.print("Batting Second: ");
		team2.teamName = s.next(); 
		
		System.out.print("Please enter the no. of overs:");
		totalOvers = s.nextInt(); 
		
		System.out.println("\n"+team1.teamName+" Team Members:");
		team1.playerInput(); 
		
		System.out.println("\n"+team2.teamName+" Team Members:");
		team2.playerInput(); 
		
	}

	private void welcome() {
		
		System.out.println("Hello, and welcome to the JAVA championships\n");
		
	}

}
