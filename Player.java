package scorecardOOPS;

public class Player {
	
	String name; 
	
	int runsScored; 
	int ballsFaced; 
	
	
	public Player(String name) {
		this.name = name; 
		runsScored = 0; 
		ballsFaced = 0;  
	}



	public void details() {
		double sr = (100.0*runsScored)/ballsFaced; 
		
		System.out.println(name+"\t"+runsScored+"\t"+ballsFaced+"\t"+sr);
	}
	
	
}
