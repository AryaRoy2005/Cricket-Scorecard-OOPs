package scorecardOOPS;

import java.util.Scanner;

public class Team {
	
	Scanner s = new Scanner(System.in); 
	String teamName; 
	Player[] players = new Player[11];
	int wickets; 
	int runs; 
	double overs; 
	
	public Team() {
		players = new Player[11]; 
		teamName = new String(); 
		wickets = 0; 
		runs = 0; 
		overs = 0.0; 
	}

	public void playerInput() {
		for(int i = 0; i<11; i++) {
			System.out.print("Player "+(i+1)+": ");
			String temp = s.nextLine(); 
			players[i] = new Player(temp); 
		}
	}
	
	public void innings(int target, int totalOvers) {
		
		int onStrike = 0; 
		
		int striker1 = 0; 
		int striker2 = 1;  
		
		for(int i = 1; i<=totalOvers; i++) {
			int j = 1; 
			while(j<=6) {
				System.out.print((i-1)+"."+(j)+": ");
				char run = s.next().charAt(0); 
				
				if(run>=48&&run<=54) {
					//0 to 6 RUNS
					players[onStrike].ballsFaced++; 
					players[onStrike].runsScored+=(run-48); 
					runs+=(run-48); 
					overs+=(0.1); 
					j++; 
					if(run==49||run==51||run==53) {
						if(onStrike==striker1) {
							onStrike=striker2; 
						}else {
							onStrike=striker1; 
						}
					}
					if(runs>=target) {
						break; 
					}
				}else if(run=='o'||run=='O') {
					//out
					players[onStrike].ballsFaced++;
					j++; 
					wickets++; 
					overs+=(0.1); 
					
					if(wickets==10) {
						break; 
					}
					
					if(onStrike==striker1) {
						if(striker1<striker2) {
							striker1=striker2+1; 
						}else {
							striker1++; 
						}
						onStrike=striker1; 
					}else {
						if(striker2<striker1) {
							striker2=striker1+1; 
						}else {
							striker2++; 
						}
						onStrike=striker2; 
						
					}
				}else if(run=='w'||run=='W') {
					runs++; 
					if(runs>=target) {
						break; 
					}
				}else {
					System.out.println("Please refer to instructions");
				}
				
				
				
				
			}
			
			//OVER END
			
			if(runs>=target) {
				break; 
			}
			
			if(wickets==10) {
				break; 
			}
			
			System.out.println("End of over "+i);
			
			
			if(onStrike==striker1) {
				onStrike = striker2; 
			}else {
				onStrike = striker1;  
			}
			
		}
		 
	}


	public void stats() {
		
		System.out.println("Batsman\t"+"Runs\t"+"Balls\t"+"Strike Rate\t");
		for(int i = 0; i<10; i++) {
			if(players[i].ballsFaced>0) {
				players[i].details(); 
			}
			
		}
		
		System.out.println("\nTOTAL: "+runs+"-"+wickets+"\n\n");
		
	}

	 
	
}
